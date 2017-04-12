/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import se.nackademin.domain.User;

/**
 *
 * @author carl
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private Map<String, Object> _objectMap = new HashMap<>();

    public SessionBean() {
    }

    
    public <PERSISTABLETYPE extends IPersistable> void persist(PERSISTABLETYPE object) {
        _objectMap.put(object.getId(), object);
    }

    public <PERSISTABLETYPE> PERSISTABLETYPE retrieve(String id) {
        PERSISTABLETYPE foundObject = (PERSISTABLETYPE) _objectMap.get(id);
        return foundObject;
    }

}
