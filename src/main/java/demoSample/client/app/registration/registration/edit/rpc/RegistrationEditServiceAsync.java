package demoSample.client.app.registration.registration.edit.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationEditServiceAsync {
    void getMessage(String username, AsyncCallback<RegistrationEdit> async);
}
