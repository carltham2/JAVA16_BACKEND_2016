package se.nackademin.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.UserHandler;


@Named
@RequestScoped
public class Logout {
    
    @Inject
    private UserHandler userHandler;
    
    public void doLogout() {
        //TODO: Redirecting users on logout
        userHandler.logout();
    }
    
}
