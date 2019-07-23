package demoSample.client.app.registration.registration.delete.rpc;

import java.io.Serializable;

public class RegistrationDelete implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    public RegistrationDelete(){}

    public void setMessage(String message) {
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
}
