package se.nackademin.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import se.nackademin.domain.User;

@Named
@SessionScoped
public class SessionBean implements Serializable {

    private Map<String, Object> _objectMap = new HashMap<>();

    public SessionBean() {

    }

    public <PERSISTABLE_TYPE extends IPersistable> void persist(PERSISTABLE_TYPE object) {
        _objectMap.put(object.getId(), object);
    }

    public <PERSISTABLE_TYPE> PERSISTABLE_TYPE retrieve(String id) {
        Object tmpUser = _objectMap.get(id);
        PERSISTABLE_TYPE foundObject = null;
        if (tmpUser != null) {

            foundObject = (PERSISTABLE_TYPE) _objectMap.get(id);
        }

        return (PERSISTABLE_TYPE) foundObject;
    }

    public Object remove(String id) {
        Object tmpObject = _objectMap.remove(id);
        return tmpObject;
    }

}