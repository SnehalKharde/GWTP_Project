package dbconnection;

import demoSample.client.app.registration.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dbconnection.DBConnection.connect;

public class FetchOnClick {

    public static Employee fetchData(String username) {
        String query="select * from employee where username = '"+username+"'";
        Employee employee=new Employee();
        try (Connection conn = (Connection) connect()) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                ResultSet resultset = pstmt.executeQuery();
                if (resultset.next()){
                    employee.setUsername(resultset.getString(2));
                    employee.setName(resultset.getString(3));
                    employee.setAddress(resultset.getString(4));
                    employee.setEmail(resultset.getString(5));
                    employee.setContact(resultset.getString(6));
                    employee.setGender(resultset.getString(2));
                }
            }
            return employee;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
