package demoSample.client.app.registration.registration.edit.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.SelectData;

public class RegistrationEditServiceImpl extends RemoteServiceServlet implements RegistrationEditService {
    @Override
    public RegistrationEdit getMessage(String username) {
       RegistrationEdit registration=new RegistrationEdit();
       System.out.println("hello");
       registration.setMessage(SelectData.selectEmployee(username));
       System.out.println("successful");
       return registration;
    }
}
