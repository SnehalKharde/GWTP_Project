package demoSample.client.app.registration.registration.fetch.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.FetchOnClick;

public class RegistrationFetchServiceImpl extends RemoteServiceServlet implements RegistrationFetchService {
    @Override
    public RegistrationFetch getMessage(String username) {
       RegistrationFetch registration=new RegistrationFetch();
       System.out.println("hello");
       registration.setMessage(FetchOnClick.fetchData(username));
       System.out.println("successful");
       return registration;
    }
}
