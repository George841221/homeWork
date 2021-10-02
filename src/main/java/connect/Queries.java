package connect;

import model.Gender;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<Users> usersData() {
        String query = "SELECT * FROM user_data";

        List<Users> usersData = new ArrayList<>();

        try {
            Statement statement = ConnectToDb.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String genderFromDB = resultSet.getString("gender").toUpperCase();
                Gender gender = Gender.valueOf(genderFromDB);
                int age = resultSet.getInt("age");
                String regData = resultSet.getString("reg_data");
                String userEmail = resultSet.getString("user_email");
                String userPassword = resultSet.getString("user_password");

                Users dataFromUsers = new Users(userId, userName, gender, age, regData, userEmail, userPassword);

                usersData.add(dataFromUsers);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usersData;
    }
}
