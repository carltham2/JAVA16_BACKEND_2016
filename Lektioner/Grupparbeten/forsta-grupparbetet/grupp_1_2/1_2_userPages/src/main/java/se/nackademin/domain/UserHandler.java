package se.nackademin.domain;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserHandler implements Serializable {
    
    private boolean isLoggedIn = false;
    private String username = "";
    
    public boolean login(String username, String password) {
        
        boolean check = FakeDB.doLogin(username, password);
        if (check==true)
        {
            this.username=username;
            isLoggedIn = true;
        }
        
        return (check);
        
    }
    
    public void logout() {
        username="";
        isLoggedIn=false;
    }
    
    
    public void doRegister(User selectedUser){
        //TODO; Lägga till en varning om id redan finns
        if(!FakeDB.isUserExists(selectedUser)){
          FakeDB.addUser(selectedUser);
        }
        //TODO: Error handling
    }
    

}
