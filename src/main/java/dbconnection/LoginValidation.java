package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dbconnection.DBConnection.connect;

public class LoginValidation {

    public static String authenticateAdmin(String username, String password) {
        String query="select * from admin where employee_name=? and employee_password=?";
        try (Connection conn = (Connection) connect()) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

               pstmt.setString(1, username);
               pstmt.setString(2, password);

                ResultSet result = pstmt.executeQuery();
               if(result.next()) {
                    System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" \n");
                    return "Login successful";
                }else
                   System.out.println("Wrong id or password");
                    return "Wrong username or password";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //System.out.println("Cannot connect to database");
        return null;
    }
}

