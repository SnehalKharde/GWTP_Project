package demoSample.client.app.registration.registration.edit.rpc;

import demoSample.client.app.registration.Employee;

import java.io.Serializable;
import java.util.ArrayList;

public class RegistrationEdit implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Employee> employee;
    public RegistrationEdit(){}

    public void setMessage(ArrayList<Employee> employee) {
        this.employee=employee;
    }
    public ArrayList<Employee> getMessage(){
        return employee;
    }
}
