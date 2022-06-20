package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.UserDAOImpl;
import com.kenit.salesweb.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.login(username,password);
        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("acc",user);
            session.setMaxInactiveInterval(86400);
            response.sendRedirect("home");
        }else {
            request.setAttribute("message","fail");
            request.getRequestDispatcher("view/login.jsp").forward(request,response);
        }
    }
}
