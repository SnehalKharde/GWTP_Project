package demoSample.client.app.registration.registration.update.rpc;

import java.io.Serializable;

public class RegistrationUpdate implements Serializable {
    private static final long serialVersionUID = 1L;
    String message;
    public RegistrationUpdate(){}

    public void setMessage(String message) {
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
}
