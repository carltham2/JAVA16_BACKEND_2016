package se.nackademin.domain;

import java.util.UUID;

public class User {
    private String username;
    private String password;
    private UUID id;
    
    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPasswordCorrect(String inputPassword) {
            return (password.equals(inputPassword));
    }

    public UUID getId() {
        return id;
    }
    
    
}
