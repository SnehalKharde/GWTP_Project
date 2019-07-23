package demoSample.client.app.registration.client.getall.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.SelectData;

public class RegistrationGetAllServiceImpl extends RemoteServiceServlet implements RegistrationGetAllService {
    @Override
    public RegistrationGetAll getMessage() {
       RegistrationGetAll registration=new RegistrationGetAll();
       System.out.println("hello");
       registration.setMessage(SelectData.selectAdmin());
       System.out.println("successful");
       return registration;
    }
}
