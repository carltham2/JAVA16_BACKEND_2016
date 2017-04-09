package se.nackademin.domain;

import se.nackademin.settings.Constants;

import java.util.Date;

/**
 * Created by carl on 04/04/17.
 */
public class User {
    private final Date loginTime;
    private String userName;
    private String password;

    public User(String newUserName, String newPassword) {
        userName=newUserName;
        password=newPassword;
        loginTime = new Date();
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

    public boolean sessionIsTimedOut() {

        long now = new Date().getTime();
        boolean sessionTimedOut =
                (loginTime.getTime()+ Constants._TIME_TO_LIVE_IN_MILLISECONDS)
                < now;
        return sessionTimedOut;
    }

}
