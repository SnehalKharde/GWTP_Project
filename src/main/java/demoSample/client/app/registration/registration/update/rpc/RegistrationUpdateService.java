package demoSample.client.app.registration.registration.update.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import demoSample.client.app.registration.Employee;

@RemoteServiceRelativePath("registrationupdate")
public interface RegistrationUpdateService extends RemoteService {
    RegistrationUpdate getMessage(Employee employee);
}

