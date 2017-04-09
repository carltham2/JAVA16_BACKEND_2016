package se.nackademin.backend;

import se.nackademin.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carl on 04/04/17.
 */
public class FakeDB {
    private Map<String, User> usersMap = new HashMap<>();

    private static FakeDB instance;

    private FakeDB()
    {
        User user = new User("carl", "secret");
        usersMap.put(user.getUserName(),user);
    }

    public static User login(String username, String newPassword) {
        if (instance == null) {
            instance = new FakeDB();
        }

        User user = instance.usersMap.get(username);
        return user;
    }
}
