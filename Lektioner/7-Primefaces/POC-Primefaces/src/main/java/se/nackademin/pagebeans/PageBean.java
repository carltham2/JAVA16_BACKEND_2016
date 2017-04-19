/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.pagebeans;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import se.nackademin.domain.User;

/**
 *
 * @author carl
 */
@Named
@RequestScoped
public class PageBean {
    
    List<User>userList = new LinkedList<User>();
    
    @PostConstruct
    public void load(){
        addUser("Carl", "Sundvisson");
        addUser("Test", "Person");
        addUser("John", "Lewis");        
    }

    private void addUser(String newFirstName, String newLastname) {
        User tmpUser = new User();
        tmpUser.setFirstName(newFirstName);
        tmpUser.setLastName(newLastname);
        userList.add(tmpUser);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    
}
