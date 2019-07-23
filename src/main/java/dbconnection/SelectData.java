package dbconnection;

import demoSample.client.app.registration.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dbconnection.DBConnection.connect;

public class SelectData {

    public static ArrayList<Employee> selectAdmin() {
        String query="select * from employee";
        try (Connection conn = (Connection) connect()) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                ResultSet resultset = pstmt.executeQuery();
                ArrayList<Employee> employeeArrayList =new ArrayList<Employee>();
                while (resultset.next()) {
                    System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3)+" \n");
                    Employee employee=new Employee();
                    resultset.getInt(1);
                    employee.setUsername(resultset.getString(2));
                    employee.setName(resultset.getString(3));
                    employee.setAddress(resultset.getString(4));
                    employee.setEmail(resultset.getString(5));
                    employee.setContact(resultset.getString(6));
                    employee.setGender(resultset.getString(7));
                    employeeArrayList.add(employee);
                }
                return employeeArrayList;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static ArrayList<Employee> selectEmployee(String username) {
        String query = "select * from employee where username like '"+username+"%'";
        try (Connection conn = (Connection) connect()) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                ResultSet resultset = pstmt.executeQuery();
                ArrayList<Employee> employeeArrayList =new ArrayList<Employee>();
                while (resultset.next()) {
                    System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3)+" \n");
                    Employee employee=new Employee();
                    resultset.getInt(1);
                    employee.setUsername(resultset.getString(2));
                    employee.setName(resultset.getString(3));
                    employee.setAddress(resultset.getString(4));
                    employee.setEmail(resultset.getString(5));
                    employee.setContact(resultset.getString(6));
                    employee.setGender(resultset.getString(7));
                    employeeArrayList.add(employee);
                }
                return employeeArrayList;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
