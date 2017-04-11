/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carl
 */
package se.nackademin.pagebeans;

import se.nackademin.domain.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import se.nackademin.backend.FakeDB;

@Named
@RequestScoped
public class UserRegistrationPageBean {

    private User user;

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String register() {
        User registeredUser = FakeDB.register(getUser());
        return "";
    }
}
