package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.UserDAOImpl;
import com.kenit.salesweb.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user-name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeat-password");
        String roleCustomer = "customer";
        User userSave = new User(email, password, roleCustomer, userName);
        if (!password.equals(repeatPassword)) {
            response.sendRedirect("view/login.jsp");
        } else {
            User userCheck = userDAO.exitedUser(email);
            if (userCheck == null){
                userDAO.saveBuyer(userSave);
                response.sendRedirect("home");
            }else {
                response.sendRedirect("view/login.jsp");
            }
        }
    }
}
