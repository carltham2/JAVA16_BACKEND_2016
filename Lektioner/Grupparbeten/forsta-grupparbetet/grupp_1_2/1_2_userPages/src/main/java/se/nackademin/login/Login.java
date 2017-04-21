package se.nackademin.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.UserHandler;


@Named
@RequestScoped
public class Login {
    
    private String username;
    private String password;
    
    @Inject
    private UserHandler userHandler;
    
    public String doLogin() {
        //TODO: Redirecting users on success
        boolean logged = userHandler.login(username, password);
        if (logged==true)
        {
            System.out.println("Login");
            return "/userPages/welcome.xhtml";
        }
        return "";
    }
    
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
