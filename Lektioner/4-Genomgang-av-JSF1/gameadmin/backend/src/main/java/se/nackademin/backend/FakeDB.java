package se.nackademin.backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import se.nackademin.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.nackademin.services.IUserService;

/**
 * Created by carl on 04/04/17.
 */
public class FakeDB implements Serializable {

    private Map<String, User> usersMap = new HashMap<>();

    private static FakeDB instance;

    private FakeDB() {
        User user = new User("Carl Sundvisson", "carl", "secret");
        usersMap.put(user.getUserName(), user);
    }

    public static User login(String username, String newPassword) {
        if (instance == null) {
            instance = new FakeDB();
        }

        User user = instance.usersMap.get(username);
        return user;
    }
}
