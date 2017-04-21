package se.nackademin.domain;

import se.nackademin.session.IPersistable;

public class User implements IPersistable{
    private String id;
    private String username;
    private String password;

    // Constructor

    public User() {
        id = "1";
    }
    
    
    // Get
    @Override
    public String getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Set
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    
    
}
