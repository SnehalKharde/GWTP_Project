package demoSample.client.app.registration.registration.edit.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registrationedit")
public interface RegistrationEditService extends RemoteService {
    RegistrationEdit getMessage(String username);
}

