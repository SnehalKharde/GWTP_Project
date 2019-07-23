package demoSample.client.app.registration.client.getall.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registrationgetall")
public interface RegistrationGetAllService extends RemoteService {
    RegistrationGetAll getMessage();
}

