package se.nackademin.backend;

import se.nackademin.domain.User;

import java.util.HashMap;
import java.util.Map;

public class FakeDB {

    private Map<String, User> _usersMap = new HashMap<>();
    private static FakeDB _instance;

    // Singleton constructor
    private FakeDB() {
        User user = new User();
        getUsersMap().put(user.getUsername(), user);
    }

    
    // Functions
    public static User doRegister(User user) {
        getInstance().getUsersMap().put(user.getUsername(), user);
        return user;
    }

    public static User login(String username, String newPassword) {
        if (_instance == null) {
            setInstance(new FakeDB());
        }
        
        User user = getInstance().getUsersMap().get(username);
        return user;
    }

    // Get
    public static FakeDB getInstance() {
        if (_instance == null) {
            // setInstance(new FakeDB());
            _instance = new FakeDB();
        }
        return _instance;
    }
    
    public Map<String, User> getUsersMap() {
        return _usersMap;
    }
    
    public static User getUser(String userName) {
        return null;
    }
    
    // Set

    public void setUsersMap(Map<String, User> usersMap) {
        this._usersMap = usersMap;
    }

    public static void setInstance(FakeDB instance) {
        FakeDB._instance = instance;
    }
}
