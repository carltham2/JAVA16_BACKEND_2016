package se.nackademin.backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import se.nackademin.domain.User;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by carl on 04/04/17.
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet implements Serializable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
            User requestUser = (User) ois.readObject();
            ois.close();
// Prepare any variables to use in this function
            String username = requestUser.getUserName();
            String password = requestUser.getPassword();
            User loggedinUser = FakeDB.login(username, password);
            ObjectOutputStream outputStream = new ObjectOutputStream(response.getOutputStream());
            outputStream.writeObject(loggedinUser);
            outputStream.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    
//  public void service(ServletRequest req, ServletResponse res)
//    throws IOException, ServletException
//  {
//    res.getWriter().println("Hello World!");
//  }

}
