package demoSample.client.registration.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import demoSample.client.app.registration.Employee;

@RemoteServiceRelativePath("registration")
public interface RegistrationService extends RemoteService {
    Registration getMessage(Employee employee);
}

