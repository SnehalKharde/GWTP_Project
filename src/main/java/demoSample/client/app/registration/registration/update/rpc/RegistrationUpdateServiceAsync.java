package demoSample.client.app.registration.registration.update.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import demoSample.client.app.registration.Employee;

public interface RegistrationUpdateServiceAsync {
    void getMessage(Employee employee, AsyncCallback<RegistrationUpdate> async);
}
