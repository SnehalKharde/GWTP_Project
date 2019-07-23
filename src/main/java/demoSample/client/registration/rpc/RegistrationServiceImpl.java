package demoSample.client.registration.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.InsertData;
import demoSample.client.app.registration.Employee;

public class RegistrationServiceImpl  extends RemoteServiceServlet implements RegistrationService {
    @Override
    public Registration getMessage(Employee employee) {
       Registration registration=new Registration();
       System.out.println("hello");
       registration.setMessage(InsertData.insertRegistration(employee));
        System.out.println("successful");
       return registration;
    }
}
