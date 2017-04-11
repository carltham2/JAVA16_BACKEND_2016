/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.services;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import se.nackademin.backend.FakeDB;
import se.nackademin.domain.User;

/**
 *
 * @author carl
 */
@Named
@SessionScoped
public class UserHandler implements Serializable {

    public User doRegister(User selectedUser) {

        User registeredUser = null;
        if (!userExists(selectedUser)) {
            registeredUser = FakeDB.doRegister(selectedUser);
        }
        return registeredUser;
    }

    private boolean userExists(User selectedUser) {
        User dbUser = FakeDB.getUser(selectedUser.getUserName());
        return dbUser == null ? false : true;
    }

}
