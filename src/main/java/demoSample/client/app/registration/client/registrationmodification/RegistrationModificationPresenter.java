package demoSample.client.app.registration.client.registrationmodification;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import demoSample.client.app.registration.Employee;
import demoSample.client.app.registration.RegistrationCallBack;
import demoSample.client.app.registration.client.getall.rpc.RegistrationGetAllService;
import demoSample.client.app.registration.client.getall.rpc.RegistrationGetAllServiceAsync;
import demoSample.client.app.registration.registration.delete.rpc.RegistrationDeleteService;
import demoSample.client.app.registration.registration.delete.rpc.RegistrationDeleteServiceAsync;
import demoSample.client.app.registration.registration.edit.rpc.RegistrationEdit;
import demoSample.client.app.registration.registration.edit.rpc.RegistrationEditService;
import demoSample.client.app.registration.registration.edit.rpc.RegistrationEditServiceAsync;
import demoSample.client.app.registration.registration.fetch.rpc.RegistrationFetch;
import demoSample.client.app.registration.registration.fetch.rpc.RegistrationFetchService;
import demoSample.client.app.registration.registration.fetch.rpc.RegistrationFetchServiceAsync;
import demoSample.client.app.registration.registration.update.rpc.RegistrationUpdate;
import demoSample.client.app.registration.registration.update.rpc.RegistrationUpdateService;
import demoSample.client.app.registration.registration.update.rpc.RegistrationUpdateServiceAsync;
import demoSample.client.place.NameTokens;
import demoSample.client.registration.rpc.RegistrationService;
import demoSample.client.registration.rpc.RegistrationServiceAsync;

public class RegistrationModificationPresenter extends Presenter<RegistrationModificationPresenter.MyView, RegistrationModificationPresenter.MyProxy> {
    interface MyView extends View {
        HasClickHandlers getSaveButton();
        HasClickHandlers getEditButton();
        HasClickHandlers getCancel();
        HasClickHandlers getmalechange();
        HasClickHandlers getfemalechange();
        HasClickHandlers getUpdateButton();
        Employee setSaveButton();
        void setmalechange();
        void setfemalechange();
        void setCancel();
        void setRadioName();
        String setUsernameToEdit(String name);
        void setEditLabels(Employee employee);
        HasKeyPressHandlers getFetch();
        void validate();
        void addEditCheckBox();
        void clearTable();
        void setUpdateDisable();
        void setUpdateEnable();
        void setButtonDisable();
    }

    @ProxyStandard
    @NameToken(NameTokens.RegistrationAddEdit)
    interface MyProxy extends ProxyPlace<RegistrationModificationPresenter> {
    }

    public static final NestedSlot SLOT_REGISTRATIONMODIFICATION = new NestedSlot();

    @Inject
    RegistrationModificationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);

    }



    //get all records module creation
    private RegistrationGetAllServiceAsync messageGetAll= GWT.create(RegistrationGetAllService.class);

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


    private RegistrationFetchServiceAsync messageFetch=GWT.create(RegistrationFetchService.class);


    @Override
    protected void onBind() {
        super.onBind();

        //save button action
        registerHandler(getView().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Employee employee = getView().setSaveButton();
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
                Employee employee = getView().setSaveButton();
                messageUpdateService.getMessage(employee, new AsyncCallback<RegistrationUpdate>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Unable to create the connection");
                    }

                    @Override
                    public void onSuccess(RegistrationUpdate registrationUpdate) {
                        String message = registrationUpdate.getMessage();
                        Window.alert(message);
                    }
                });
            }
        }));
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);
        final String name=request.getParameter("name",null);
        if(name==null){
            getView().setUpdateDisable();
            getView().setCancel();
        }
        else{
            Window.alert(name);
            getView().setUsernameToEdit(name);
            getView().setUpdateEnable();
            getView().setButtonDisable();
            //get data button action
                    String username = getView().setUsernameToEdit(name);
                    messageFetch.getMessage(username, new AsyncCallback<RegistrationFetch>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            Window.alert("Unable to obtain server response ");
                        }

                        @Override
                        public void onSuccess(RegistrationFetch registration) {
                            Employee employee = registration.getMessage();
                            if (employee == null) {
                                Window.alert("No records found");

                            } else {
                                getView().setEditLabels(employee);
                            }
                        }
                    });
                }
            }
        }

