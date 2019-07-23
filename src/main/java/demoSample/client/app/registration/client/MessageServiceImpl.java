package demoSample.client.app.registration.client;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dbconnection.LoginValidation;

public class MessageServiceImpl extends RemoteServiceServlet implements MessageService{
   // private static final long serialVersionUID = 1L;

    public Message getMessage(String username,String password) {

        Message message=new Message();
        message.setMessage(LoginValidation.authenticateAdmin(username,password));
        return message;
    }
}
