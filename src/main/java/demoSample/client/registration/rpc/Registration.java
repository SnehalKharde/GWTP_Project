package demoSample.client.registration.rpc;

import java.io.Serializable;

public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    public Registration(){};

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
