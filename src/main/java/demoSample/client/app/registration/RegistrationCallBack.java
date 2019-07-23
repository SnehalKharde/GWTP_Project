package demoSample.client.app.registration;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import demoSample.client.registration.rpc.Registration;

public class RegistrationCallBack implements AsyncCallback<Registration> {


    @Override
    public void onFailure(Throwable throwable) {
        Window.alert("Unable to obtain server response: ");
    }

    @Override
    public void onSuccess(Registration registration) {
        Window.alert(registration.getMessage());
    }
}
