package demoSample.client.app.registration.registration.update.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.UpdateData;
import demoSample.client.app.registration.Employee;

public class RegistrationUpdateServiceImpl extends RemoteServiceServlet implements RegistrationUpdateService {
    @Override
    public RegistrationUpdate getMessage(Employee employee) {
       RegistrationUpdate registration=new RegistrationUpdate();
       System.out.println("hello");
       registration.setMessage(UpdateData.updateAdmin(employee));
       System.out.println("successful");
       return registration;
    }
}
