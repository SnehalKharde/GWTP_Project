package demoSample.client;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

public class HomeView extends ViewImpl implements HomePresenter.MyView {
    @UiField Button save;
    @UiField TextBox userField;
    @UiField PasswordTextBox passwordField;
    @UiField Label messageLabel;


    Admin admin;
    @Override
    public HasClickHandlers getSaveButton() {
        return save;
    }

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @Inject
    HomeView(@NotNull Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setAdmin(){
        admin=new Admin(userField.getText(),passwordField.getText());

    }

    @Override
    public Admin getAdmin(){
        return admin;
    }

    @Override
    public void setMessageLabel(String message){
        messageLabel.setText(message);

    }

    @Override
    public String getMessageLabel(){
        return messageLabel.getText();
    }

    @Override
    public int validate(String admin_name, String password){
       return 1;
    }

}

