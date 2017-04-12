/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.domain;

/**
 *
 * @author carl
 */
public class User {

    private String userName;
    private String password;

    // Getters and setters
    public String getUserName() {
        if (userName == null) {
            userName = "carl";
        }
        return userName;
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public String getPassword() {

        if (password == null) {
            password = "secret";
        }
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
