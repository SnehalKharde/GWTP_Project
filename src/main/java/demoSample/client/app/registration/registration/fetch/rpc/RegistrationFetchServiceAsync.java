package demoSample.client.app.registration.registration.fetch.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationFetchServiceAsync {
    void getMessage(String username, AsyncCallback<RegistrationFetch> async);
}
