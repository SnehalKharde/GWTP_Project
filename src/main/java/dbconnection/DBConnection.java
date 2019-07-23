package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connection=null;
    private static String url="jdbc:postgresql://localhost/Employee";
    private static String user="postgres";
    private static String password="aka1198";

    //database connection
    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
