package dbconnection;

import demoSample.client.app.registration.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static dbconnection.DBConnection.connect;

public class InsertData {
    public static String insertRegistration(Employee employee) {
        String query = "insert into employee(username,employee_name,address,email_id,contact,gender) values(?,?,?,?,?,?)";
            try {
                System.out.println("in try");
                Connection conn = (Connection) connect();
                PreparedStatement statement =conn.prepareStatement(query);

                statement.setString(1,employee.getUsername());
                statement.setString(2,employee.getName());
                statement.setString(3,employee.getAddress());
                statement.setString(4,employee.getEmail());
                statement.setString(5,employee.getContact());
                statement.setString(6,employee.getGender());
                int i=statement.executeUpdate();
                if(i>0){
                    System.out.println("executed");
                    return "Registered successfully";
                }
                else return "not registered";

            }catch (Exception e){
                e.printStackTrace();
            }
            return "not registered";
    }
}
