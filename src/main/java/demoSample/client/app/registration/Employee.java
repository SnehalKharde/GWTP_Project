package demoSample.client.app.registration;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class Employee implements IsSerializable {
    String username;
    String name;
    String address;
    public String gender;
    String email;
    String contact;

    public Employee(){}

    public Employee(String username, String name,String address,String gender,String contact,String email){
        this.username=username;
        this.name=name;
        this.address=address;
        this.gender=gender;
        this.email=email;
        this.contact=contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
