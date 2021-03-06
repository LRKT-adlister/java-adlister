package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
//      error message code
        request.setAttribute("errors", false);

        boolean validAttempt = false;
//        Password.check(password, user.getPassword());

        if (user == null) {
            request.setAttribute("errors", true);
            request.setAttribute("username_error", true);
//            response.sendRedirect("/login");
//            return;
        }
        else {
            validAttempt = Password.check(password, user.getPassword());
        }

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            request.setAttribute("errors", true);
            request.setAttribute("password_error", true);
//            response.sendRedirect("/login");
        }
        if((Boolean)request.getAttribute("errors")){
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
