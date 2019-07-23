package demoSample.client.app.registration.registration.delete.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationDeleteServiceAsync {
    void getMessage(String username, AsyncCallback<RegistrationDelete> async);
}
