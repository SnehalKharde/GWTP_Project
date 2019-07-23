package demoSample.client.app.registration.registration.delete.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registrationdelete")
public interface RegistrationDeleteService extends RemoteService {
    RegistrationDelete getMessage(String username);
}

