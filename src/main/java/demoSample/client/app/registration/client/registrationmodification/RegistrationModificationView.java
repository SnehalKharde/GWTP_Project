package demoSample.client.app.registration.client.registrationmodification;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;
import demoSample.client.app.registration.Employee;

import javax.inject.Inject;


public class RegistrationModificationView extends ViewImpl implements RegistrationModificationPresenter.MyView {
    interface Binder extends UiBinder<Widget, RegistrationModificationView> {
    }

    private Employee employee=new Employee();
    @UiField
    Button save;
    @UiField
    Button cancel;
    @UiField
    TextBox usernameField;
    @UiField
    TextBox contactField;
    @UiField
    TextBox emailField;
    @UiField
    TextBox nameField;
    @UiField
    RadioButton male;
    @UiField
    RadioButton female;
    @UiField
    TextArea addressField;
    @UiField
    Button update;
    @UiField
    HTMLPanel main;

    @Override
    public void setRadioName(){
        female.setName("Female");
        male.setName("Male");
    }

    @Override
    public String setUsernameToEdit(String name) {
        usernameField.setText(name);
        return usernameField.getValue();
    }

    @Override
    public Employee setSaveButton(){
        employee.setUsername(usernameField.getValue());
        employee.setName(nameField.getValue());
        employee.setAddress(addressField.getText());
        employee.setContact(contactField.getValue());
        employee.setEmail(emailField.getValue());
        if(male.isChecked()){
            employee.setGender("Male");
        }else if(female.isChecked()){
            employee.setGender("Female");
        }
        if(employee==null){
            Window.alert("No record entered");
            return null;
        }else
            return employee;
    }

    @Override
    public HasClickHandlers getmalechange() {
        return male;
    }

    @Override
    public HasClickHandlers getfemalechange() {
        return female;
    }

    @Override
    public HasClickHandlers getUpdateButton() {
        return update;
    }


    @Override
    public HasClickHandlers getSaveButton() {
        return save;
    }

    @Override
    public HasClickHandlers getEditButton() {
        return null;
    }

    @Override
    public HasClickHandlers getCancel(){
        return cancel;
    }

    @Override
    public void setCancel(){
        nameField.setText("");
        usernameField.setText("");
        addressField.setText("");
        contactField.setText("");
        emailField.setText("");
        male.setChecked(false);
        female.setChecked(false);
    }

    @Override
    public void setEditLabels(Employee employee){
        usernameField.setText(employee.getUsername());
        nameField.setText(employee.getName());
        addressField.setText(employee.getAddress());
        emailField.setText(employee.getEmail());
        contactField.setText(employee.getContact());
        if(employee.gender.equals("Male")){
            male.setChecked(true);
            female.setChecked(false);
        }else if(employee.gender.equals("Female")){
            female.setChecked(true);
            male.setChecked(false);
        }
        //Window.alert("done successfully");
    }

    @Override
    public HasKeyPressHandlers getFetch() {
        return null;
    }

    @Override
    public void validate() {

    }

    @Override
    public void addEditCheckBox() {

    }

    @Override
    public void clearTable() {

    }

    @Override
    public void setUpdateDisable() {
        update.setVisible(false);
        save.setVisible(true);
    }

    @Override
    public void setUpdateEnable() {
        update.setVisible(true);
        save.setVisible(false);
    }

    @Override
    public void setButtonDisable() {
        save.setVisible(false);
    }


    @Override
    public void setmalechange(){
        male.setChecked(false);
    }

    @Override
    public void setfemalechange() {
        female.setChecked(false);
    }


    @Inject
    RegistrationModificationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(RegistrationModificationPresenter.SLOT_REGISTRATIONMODIFICATION, main);
    }
}
