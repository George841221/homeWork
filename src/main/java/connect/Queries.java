package connect;

import model.Gender;
import model.Status;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    public static List<Users> usersData(String querySelect) {

        List<Users> usersData = new ArrayList<>();

        try {
            Statement statement = ConnectToDb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String genderFromDB = resultSet.getString("gender").toUpperCase();
                Gender gender = Gender.valueOf(genderFromDB);
                String statusFromDB = resultSet.getString("user_status").toUpperCase();
                Status status = Status.valueOf(statusFromDB);
                int age = resultSet.getInt("age");
                Timestamp REG_DATE = resultSet.getTimestamp("reg_date");
                String userEmail = resultSet.getString("user_email");
                String userPassword = resultSet.getString("user_password");

                Users dataFromUsers = new Users(userId, userName, gender, status,
                        age, REG_DATE, userEmail, userPassword);

                usersData.add(dataFromUsers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersData;
    }

    public static void sourcingUserFromDb(String querySelect, String sourceName) {

        try {
            PreparedStatement preparedStatement = ConnectToDb.connection.prepareStatement(querySelect);
            preparedStatement.setString(1, sourceName);
            ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    System.out.println("User ID: " + rs.getString(1));
                    System.out.println("User name: " + rs.getString(2));
                    System.out.println("Gender: " + rs.getString(3));
                    System.out.println("Status: " + rs.getString(4));
                    System.out.println("Age: " + rs.getString(5));
                    System.out.println("Registration date: " + rs.getString(6));
                    System.out.println("User e-mail: " + rs.getString(7));
                    System.out.println("User password: " + rs.getString(8));
                }
            }
         catch (SQLException ignored) {
        }
    }
}
