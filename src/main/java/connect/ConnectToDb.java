package connect;

import config.ConfigFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDb {

    protected static Connection connection = null;

    public static void connectToMyDb() {
        try {
            connection = DriverManager.getConnection(ConfigFile.CONN,ConfigFile.USER_NAME,ConfigFile.PASSWORD);
            // System.out.println("Connected");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}