/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.LoginDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import model.LoginModel;
import object.Account;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    String usernameEntered;
        String passwordEntered;
        Account user;
    

    @Override
    protected  void doGet(HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            RequestDispatcher rd =
                    request.getRequestDispatcher("WEB-INF/login.jsp");
            rd.forward(request, response);
            request.setAttribute("account", user);
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
        usernameEntered = request.getParameter("username");
        passwordEntered = request.getParameter("password");

        LoginModel loginModel = new LoginModel();
        user = loginModel.login(usernameEntered, passwordEntered);

    }

    private void login(HttpServletRequest request,
                       HttpServletResponse response, Account user) {
        try {
            HttpSession session = request.getSession();
            session.setAttribute("userLoggedIn", user);

            response.sendRedirect("/search");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
