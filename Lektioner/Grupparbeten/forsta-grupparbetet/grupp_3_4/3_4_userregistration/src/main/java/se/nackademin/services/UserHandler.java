/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.services;

import se.nackademin.backend.FakeDB;
import se.nackademin.domain.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * @author christopherolsson
 */
@Named
@SessionScoped
public class UserHandler implements Serializable {

    public User doRegister(User selectedUser) {
        Map<String, User> users = FakeDB.getInstance();
        User user = users.get(selectedUser.getUserName());
        if (user == null) {
            users.put(selectedUser.getUserName(), selectedUser);
        }
        return user;
    }

}
