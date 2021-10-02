package connect;

import config.ConfigFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDb {

    public static Connection connection = null;

    public static void connenct() {
        try {
            connection = DriverManager.getConnection(ConfigFile.CONN,ConfigFile.USER_NAME,ConfigFile.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Connected");
    }
}