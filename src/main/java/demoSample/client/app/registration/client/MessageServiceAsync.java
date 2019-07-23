package demoSample.client.app.registration.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync{
    //void getMessage(String input, AsyncCallback<Admin> callback);

    void getMessage(String username,String password, AsyncCallback<Message> async);

   // void getMessage(Employee employee, MessageCallBack messageCallBack);

    //void getMessage(String input, MessageCallBack async);

    //void getMessage(String input,  async);
}
