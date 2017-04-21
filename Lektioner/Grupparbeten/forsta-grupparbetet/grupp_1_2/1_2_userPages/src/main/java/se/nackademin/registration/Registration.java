package se.nackademin.registration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.User;
import se.nackademin.domain.UserHandler;

@Named
@RequestScoped
public class Registration {
    
    private String username;
    private String password;
    
@Inject
private UserHandler userHandler;
    
    //TODO: Error handling of failed register
    //TODO: Redirecting users on success
    public String doRegister() {
        User user = new User(username,password);
        userHandler.doRegister(user);
        
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
