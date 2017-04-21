package se.nackademin.backend;


import se.nackademin.domain.User;

import java.util.HashMap;
import java.util.Map;

public class FakeDB {


    private static final Map<String, User> users = new HashMap<>();

    static {
        User user = new User("John", "secret", "john@doe.com");
        users.put(user.getUserName(), user);
    }

    public static Map<String, User> getInstance() {
        return users;
    }
}
