package jantristanmilan;

import jantristanmilan.data.MySQLUserDAO;
import jantristanmilan.data.User;
import jantristanmilan.data.UserDAO;
import jantristanmilan.utils.BeanUtilities;
import jantristanmilan.utils.DatabaseUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected  void doGet(HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            RequestDispatcher rd =
                    request.getRequestDispatcher("WEB-INF/register.jsp");
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
        try {
            
            System.out.println(DatabaseUtilities.getConnection("ptf_brad"));
            
            User user = new User();
            //BeanUtilities.populate(user, request);
            
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));
                    
            
            UserDAO userDAO = new MySQLUserDAO();
            userDAO.create(user);

            request.setAttribute("isAccountCreated", true);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
            rd.forward(request, response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}