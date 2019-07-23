package dbconnection;

import java.sql.Connection;
import java.sql.Statement;

import static dbconnection.DBConnection.connect;

public class DeleteRecord {
    public static String deleteRecord(String username) {
        String query = "delete from employee where username='"+username+"'";
        try {
            Connection conn = (Connection) connect();
            Statement statement = conn.createStatement();
            System.out.println("Record about to delete");
            statement.execute(query);
            System.out.println("Record deleted");
            return "Successfully deleted record";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "deletion failed";
    }
}
