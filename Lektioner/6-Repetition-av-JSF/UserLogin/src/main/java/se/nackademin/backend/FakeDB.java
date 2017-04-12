package se.nackademin.backend;

import se.nackademin.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carl on 04/04/17.
 */
public class FakeDB {

    public static User getUser(String userName) {
        return getInstance().getUsersMap().get(userName);
    }
    private Map<String, User> _usersMap = new HashMap<>();

    private static FakeDB _instance;

    private FakeDB() {
        User user = new User();
        getUsersMap().put(user.getUserName(), user);
    }

    public static User doRegister(User user) {
        getInstance().getUsersMap().put(user.getUserName(), user);
        return user;
    }

    public static User login(String username, String newPassword) {
        User user = getInstance().getUsersMap().get(username);
        return user;
    }

    public Map<String, User> getUsersMap() {
        return _usersMap;
    }

    public void setUsersMap(Map<String, User> usersMap) {
        this._usersMap = usersMap;
    }

    public static FakeDB getInstance() {
        if (_instance == null) {
            setInstance(new FakeDB());
        }
        return _instance;
    }

    public static void setInstance(FakeDB instance) {
        FakeDB._instance = instance;
    }

}
