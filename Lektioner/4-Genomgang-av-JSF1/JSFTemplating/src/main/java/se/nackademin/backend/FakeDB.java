package se.nackademin.backend;

import se.nackademin.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carl on 04/04/17.
 */
public class FakeDB {
    private Map<String, User> _usersMap = new HashMap<>();

    private static FakeDB _instance;

    private FakeDB()
    {
        User user = new User();
        getUsersMap().put(user.getUserName(),user);
    }

    public static User register(User user) {
        getInstance().getUsersMap().put(user.getUserName(), user);
        user.setIsActive(true);
        return user;
    }

    public static User login(String username, String newPassword) {
        if (getInstance() == null) {
            setInstance(new FakeDB());
        }

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
        return _instance;
    }

    public static void setInstance(FakeDB instance) {
        FakeDB._instance = instance;
    }
    
}
