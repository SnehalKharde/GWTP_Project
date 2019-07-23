package demoSample.client.registration.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import demoSample.client.app.registration.Employee;

public interface RegistrationServiceAsync {
    void getMessage(Employee employee, AsyncCallback<Registration> async);
}
