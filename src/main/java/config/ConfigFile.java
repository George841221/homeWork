package config;

public class ConfigFile {

    public static final String CONN = "jdbc:mysql://localhost:3306/blogsDB";

    public final static String USER_NAME = System.getenv("DB_USER");
    public final static String PASSWORD = System.getenv("DB_PASSWORD");
}