package demoSample.client.app.registration;
public class Admin   {
    String Employee_name;
    String password;

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String employee_name, String password){
        this.Employee_name=employee_name;
        this.password=password;
    }
}


