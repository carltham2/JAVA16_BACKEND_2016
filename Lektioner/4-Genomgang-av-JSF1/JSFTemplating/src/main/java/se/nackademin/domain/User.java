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
    private String password1;
    private String password2;
    private String email1;
    private String email2;
    private String name;
    private boolean _isActive;

    public User() {
    }

    public String getUserName() {
        if (userName == null) {
            userName = "carl-igen-2";
        }
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFullName() {
        return name;
    }

    public void setFullName(String name) {
        this.name = name;
    }

    public boolean isIsActive() {
        return _isActive;
    }

    public void setIsActive(boolean _isActive) {
        this._isActive = _isActive;
    }
    
    
    

}
