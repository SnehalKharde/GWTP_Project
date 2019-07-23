package demoSample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import demoSample.client.app.registration.client.Message;
import demoSample.client.app.registration.client.MessageService;
import demoSample.client.app.registration.client.MessageServiceAsync;
import demoSample.client.place.NameTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy>  {

  //  @Inject private MessageServiceAsync getMessage
    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    interface MyView extends View {
        HasClickHandlers getSaveButton();
        void setAdmin();
        Admin getAdmin();
        String getMessageLabel();
        void setMessageLabel(String message);
        int validate(String admin_name, String password);
    }

    @Inject
    PlaceManager placeManager;
    //DBConnectionAsync message=GWT.create(DBConnection.class);
    private MessageServiceAsync messageService =
            GWT.create(MessageService.class);

    //click handler on save button
    @Override
    protected void onBind() {
        super.onBind();
        registerHandler(getView().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //System.out.println("hello called");
                getView().setAdmin();
                String admin_name=getView().getAdmin().getEmployee_name();
                 String password=getView().getAdmin().getPassword();
                 final int result=getView().validate(admin_name,password);
                 if(result==1){
                     //RPC call
                     messageService.getMessage(admin_name, password, new AsyncCallback<Message>() {
                         @Override
                         public void onFailure(Throwable throwable) {
                             Window.alert("Unable to obtain server response: ");
                         }

                         @Override
                         public void onSuccess(Message message) {
                             Window.alert(message.getMessage());
                             if(message.getMessage().equals("Login successful")){
                                 PlaceRequest myRequest = new PlaceRequest(NameTokens.HOMEModule);
                                 placeManager.revealRelativePlace(myRequest);
                             }
                         }
                     });

                    // final RequestDispatcher requestDispatcher.
                 }
                 else{
                     Window.alert("Wrong username or password");
                 }
            }
        }));
    }



    //public static final NestedSlot SLOT_MAIN = new NestedSlot();

    @Inject
    HomePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

}
