package demoSample.client.app.registration.registration.delete.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.DeleteRecord;

public class RegistrationDeleteServiceImpl extends RemoteServiceServlet implements RegistrationDeleteService {
    @Override
    public RegistrationDelete getMessage(String username) {
       RegistrationDelete registration=new RegistrationDelete();
       System.out.println("hello");
       registration.setMessage(DeleteRecord.deleteRecord(username));
       System.out.println("successful");
       return registration;
    }
}
