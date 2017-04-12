/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.pagebeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.User;
import se.nackademin.session.SessionBean;

/**
 *
 * @author carl
 */
@Named
@RequestScoped
public class LoginPageBean {

    @Inject
    SessionBean sessionHandler;

    private User selectedUser;

    public String doLogin() {
        if (getSessionHandler().retrieve(getSelectedUser().getId())) {
            throw new RuntimeException("Du är redan inloggad "
                    + getSelectedUser().getUserName());
        }
        getSessionHandler().persist(getSelectedUser());
        return "/userPages/welcome.xhtml";
    }

    // Getters and setters
    public User getSelectedUser() {
        if (selectedUser == null) {
            selectedUser = new User();
        }
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;

    }

    public SessionBean getSessionHandler() {
        return sessionHandler;
    }

    public void setSessionHandler(SessionBean sessionHandler) {
        this.sessionHandler = sessionHandler;
    }
}
