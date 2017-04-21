package se.nackademin.pagebeans;


import se.nackademin.domain.User;
import se.nackademin.services.UserHandler;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * @author christopherolsson
 */
@Named
@RequestScoped
public class RegisterBean {

    private String userName;
    private String password;
    private String email;


    @Inject
    private UserHandler userHandler;

    public String doRegister() {
        User newUser = new User(userName, password, email);
        User registeredUser = userHandler.doRegister(newUser);
        return registeredUser != null ? "User '" + userName + "' is already registered" : "outcomes/registrationSuccess" ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
