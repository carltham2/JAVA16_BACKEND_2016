package se.nackademin.pagebeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.User;
import se.nackademin.session.SessionBean;

@Named
@RequestScoped
public class AuthenticationPageBean {

    @Inject
    private SessionBean sessionHandler;
    private User selectedUser;
    private String inputUsername;
    private String inputPassword;
    private String wawa;

    @PostConstruct
    public void load() {
        selectedUser = new User();
    }

    // outcome
    public String doLogin() {
        if (getSessionHandler().retrieve(getSelectedUser().getId()) != null) {
            throw new RuntimeException("Du är redan inloggad " + getSelectedUser().getUsername());
        }
        getSessionHandler().persist(getSelectedUser());
        return "/userPages/welcomeTemplate.xhtml";
    }

    public String doLogout() {
        getSessionHandler().remove(getSelectedUser().getId());
        return "/index.xhtml";
    }

    // set
    public void setSessionHandler(SessionBean sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    public void setSelectedUser() {
        selectedUser.setUsername(getInputUsername());
        selectedUser.setPassword(getInputPassword());
    }

    public void setInputUsername(String inputUsername) {
        this.inputUsername = inputUsername;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    // get
    public SessionBean getSessionHandler() {
        return sessionHandler;
    }

    public User getSelectedUser() {
        if (selectedUser == null) {
            setSelectedUser();
        }
        return selectedUser;
    }

    public String getInputUsername() {
        if (inputUsername == null) {
            inputUsername = "";
        }
        return inputUsername;
    }

    public String getInputPassword() {
        if (inputPassword == null) {
            inputPassword = "";
        }
        return inputPassword;
    }

}
