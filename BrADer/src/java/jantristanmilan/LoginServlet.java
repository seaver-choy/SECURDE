package jantristanmilan;

import jantristanmilan.data.MySQLUserDAO;
import jantristanmilan.data.User;
import jantristanmilan.data.UserDAO;
import jantristanmilan.utils.SecurityUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected  void doGet(HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            RequestDispatcher rd =
                    request.getRequestDispatcher("WEB-INF/login.jsp");
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException {
        String usernameEntered = request.getParameter("username");
        String passwordEntered = request.getParameter("password");

        UserDAO userDAO = new MySQLUserDAO();
        User user = userDAO.get(usernameEntered);

        if (user != null && SecurityUtilities
                .isMatch(passwordEntered, user.getPassword())) {
            login(request, response, user);
        } else {
            // TODO: Show error message
        }
    }

    private void login(HttpServletRequest request,
                       HttpServletResponse response, User user) {
        try {
            HttpSession session = request.getSession();
            session.setAttribute("userLoggedIn", user);

            response.sendRedirect("/search");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
