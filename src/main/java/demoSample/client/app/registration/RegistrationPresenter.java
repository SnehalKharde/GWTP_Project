package demoSample.client.app.registration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
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
import demoSample.client.app.registration.client.getall.rpc.RegistrationGetAll;
import demoSample.client.app.registration.client.getall.rpc.RegistrationGetAllService;
import demoSample.client.app.registration.client.getall.rpc.RegistrationGetAllServiceAsync;
import demoSample.client.app.registration.registration.delete.rpc.RegistrationDeleteService;
import demoSample.client.app.registration.registration.delete.rpc.RegistrationDeleteServiceAsync;
import demoSample.client.app.registration.registration.edit.rpc.RegistrationEdit;
import demoSample.client.app.registration.registration.edit.rpc.RegistrationEditService;
import demoSample.client.app.registration.registration.edit.rpc.RegistrationEditServiceAsync;
import demoSample.client.app.registration.registration.update.rpc.RegistrationUpdateService;
import demoSample.client.app.registration.registration.update.rpc.RegistrationUpdateServiceAsync;
import demoSample.client.place.NameTokens;
import demoSample.client.registration.rpc.RegistrationService;
import demoSample.client.registration.rpc.RegistrationServiceAsync;

import java.util.ArrayList;


public class RegistrationPresenter extends Presenter<RegistrationPresenter.MyView, RegistrationPresenter.MyProxy> {
    interface MyView extends View {
        void getTable(ArrayList<Employee> employeeArrayList);
         String setUsernameToEdit();
        HasKeyPressHandlers getFetch();
        void addEditCheckBox();
        void clearTable();
        HasClickHandlers go_to_edit();
       // void setRadio();
    }

   @Inject
   public RegistrationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy,RevealType.Root);

    }

    //get all records module creation
    private RegistrationGetAllServiceAsync messageGetAll=GWT.create(RegistrationGetAllService.class);

    //register module module creation
    private RegistrationServiceAsync messageService =
            GWT.create(RegistrationService.class);

    //edit module creation
   private RegistrationEditServiceAsync messageFetchOnCLickService =
            GWT.create(RegistrationEditService.class);

    //update module creation
    private RegistrationUpdateServiceAsync messageUpdateService =
            GWT.create(RegistrationUpdateService.class);

    //update module creation
    private RegistrationDeleteServiceAsync messageDeleteService =
            GWT.create(RegistrationDeleteService.class);

   /* //fetching records on key press
    private RegistrationFetchServiceAsync messageFetchService =
            GWT.create(RegistrationFetchService.class);
*/

    @Inject
    PlaceManager placeManager;
    //onbind
    @Override
    protected void onBind() {
        super.onBind();

        //getAll records
            messageGetAll.getMessage(new AsyncCallback<RegistrationGetAll>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Can't process data");
            }

            @Override
            public void onSuccess(RegistrationGetAll registrationGetAll) {
                getView().clearTable();
              //  getView().getTable(registrationGetAll.getMessage());

            }
        });

        //fetching records on key pressed
        registerHandler(getView().getFetch().addKeyPressHandler(new KeyPressHandler() {
            String username=getView().setUsernameToEdit();
            @Override
            public void onKeyPress(KeyPressEvent keyPressEvent) {
                 username=getView().setUsernameToEdit();

                    messageFetchOnCLickService.getMessage(username, new AsyncCallback<RegistrationEdit>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            Window.alert("Cant connect to server");
                        }

                        @Override
                        public void onSuccess(RegistrationEdit registrationEdit) {
                           // getView().getTable(registrationEdit.getMessage());

                        }
                    });
            }}));


        //edit button
        registerHandler(getView().go_to_edit().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                PlaceRequest placeRequest=new PlaceRequest(NameTokens.RegistrationAddEdit);
                placeManager.revealPlace(placeRequest);
            }
        }));

/*       //save button action
       registerHandler(getView().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Employee employee=getView().setSaveButton();
                messageService.getMessage(employee, new RegistrationCallBack());
                getView().setCancel();
            }
        }));

       //cancel button action
        registerHandler(getView().getCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                getView().setCancel();
            }
        }));
*/
        /*//get data button action
        registerHandler(getView().getEditButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                //getView().getTable();
                String username=getView().setUsernameToEdit();
               messageEditService.getMessage(username, new  AsyncCallback<RegistrationEdit>(){
                    @Override
                public void onFailure(Throwable throwable){
                    Window.alert("Unable to obtain server response ");
                }

                @Override
                public void onSuccess(RegistrationEdit registration) {
                    Employee employee = registration.getMessage();
                    if (employee == null) {
                        Window.alert("No records found");
                        //getView().setCancel();
                    } else {
                       // getView().setEditLabels(employee);
                    }
                }
                });
            }
        }));*/
/*
        //change radio button change
        registerHandler(getView().getmalechange().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                getView().setfemalechange();
            }

        }));
        registerHandler(getView().getfemalechange().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                getView().setmalechange();
            }

        }));

        //update button operation
        registerHandler(getView().getUpdateButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Employee employee=getView().setSaveButton();
                messageUpdateService.getMessage(employee, new AsyncCallback<RegistrationUpdate>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Unable to create the connection");
                    }

                    @Override
                    public void onSuccess(RegistrationUpdate registrationUpdate) {
                        String message=registrationUpdate.getMessage();
                        Window.alert(message);
                    }
                });
            }
        }));

        //delete module
        registerHandler(getView().getDeleteButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                    String username=getView().setUsernameToEdit();
                    if(!username.equals("")) {
                        boolean a=Window.confirm("Are you sure");
                        if(a){
                            messageDeleteService.getMessage(username, new AsyncCallback<RegistrationDelete>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            Window.alert("Unable to connect to server");
                        }

                        @Override
                        public void onSuccess(RegistrationDelete registrationDelete) {
                            Window.alert(registrationDelete.getMessage());
                            getView().setCancel();
                        }
                    });
                }
                }else
                    Window.alert("Enter username to delete record");
            }
        }));
*/


    }
    @ProxyStandard
    @NameToken(NameTokens.HOMEModule)
    interface MyProxy extends ProxyPlace<RegistrationPresenter>{
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
       super.prepareFromRequest(request);
    }
}
