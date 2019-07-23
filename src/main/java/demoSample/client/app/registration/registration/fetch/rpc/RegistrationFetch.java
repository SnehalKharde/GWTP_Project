package demoSample.client.app.registration.registration.fetch.rpc;

import demoSample.client.app.registration.Employee;

import java.io.Serializable;

public class RegistrationFetch implements Serializable {
    private static final long serialVersionUID = 1L;
    private Employee employee;
    public RegistrationFetch(){}

    public void setMessage(Employee employee) {
        this.employee=employee;
    }
    public Employee getMessage(){
        return employee;
    }
}
