package demoSample.client.app.registration.registration.fetch.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registrationfetch")
public interface RegistrationFetchService extends RemoteService {
    RegistrationFetch getMessage(String username);
}

