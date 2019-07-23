package dbconnection;

import demoSample.client.app.registration.Employee;

import java.sql.Connection;
import java.sql.Statement;

import static dbconnection.DBConnection.connect;

public class UpdateData {
    public static String updateAdmin(Employee employee) {
        String query = "update employee set employee_name='"+employee.getName()+"',address='"+employee.getAddress()+"',email_id='"+employee.getEmail()+"',contact='"+employee.getContact()+"' , gender='"+employee.getGender()+"' where username='"+employee.getUsername()+"'";
        try {
            Connection conn = (Connection) connect();
            Statement statement = conn.createStatement();
            System.out.println("Record dkjsfnsjdnn updated");
            statement.execute(query);
            System.out.println("Record updated");
            return "Successfully updated record";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Updation  failed";
    }
}
