package config;

public class Helper {

    public static String allUsersData = "SELECT * FROM user_data";
    public static String statusUsersData = "SELECT * FROM user_data WHERE user_status = 'admin'";
    public static String selectFromDbAUser = "SELECT * FROM user_data WHERE user_name = ?";
}
