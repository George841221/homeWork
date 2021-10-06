package connect;

import model.Gender;
import model.Status;
import model.Users;


import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

                Users dataFromUsers = new Users(userId, userName, gender, status, age, REG_DATE, userEmail, userPassword);

                usersData.add(dataFromUsers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersData;
    }

    /*public static List<String> test(String querySelect) {
        List<String> userList = new ArrayList<>();

        try {
                Statement st = ConnectToDb.connection.createStatement();
                ResultSet rs = st.executeQuery(querySelect);
                while (rs.next()) {
                    int numColumns = rs.getMetaData().getColumnCount();
                    rs.getString(1);
                    rs.getString(2);
                    rs.getString(3);
                    rs.getString(4);
                    rs.getString(5);
                    rs.getString(6);
                    rs.getString(7);
                    rs.getString(8);
                    for (int i = 1; i <= numColumns; i++) {
                        System.out.println("COLUMN " + i + " = " + rs.getObject(i));
                    }
                }
            }
         catch (SQLException ignored) {
        }
        return userList;
    }*/
}
