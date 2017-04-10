package se.nackademin.domain;

import java.io.Serializable;
import se.nackademin.settings.Constants;

import java.util.Date;

/**
 * Created by carl on 04/04/17.
 */
public class User implements IUser, Serializable {

    private final Date loginTime;
    private  String name;
    private  String userName;
    private String password;

    public User(String newName, String newUserName, String newPassword) {
        if (newName==null) {
            newName="Carl Sundvisson";
            
        }
        name = newName;
        userName = newUserName;
        password = newPassword;
        loginTime = new Date();
    }

    public User() {
        this(null, null, null);
    }

    public User(String username, String password) {
        this(null, username, password);
    }

    @Override
    public boolean sessionIsTimedOut() {

        long now = new Date().getTime();
        boolean sessionTimedOut
                = (loginTime.getTime() + Constants._TIME_TO_LIVE_IN_MILLISECONDS)
                < now;
        return sessionTimedOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}
