package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.PurchaseDAOImpl;
import com.kenit.salesweb.model.Purchase;
import com.kenit.salesweb.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddOrderServlet", value = "/add-order")
public class AddOrderServlet extends HttpServlet {
    private PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("cart") != null){
            User user = (User) session.getAttribute("acc");
            purchaseDAO.addToOder(user.getUserID());
            List<Purchase> purchaseList = purchaseDAO.findAllPurchaseOfUser(user.getUserID());
            session.setAttribute("cart",purchaseList);
            response.sendRedirect("cart");
        }else {
            response.sendRedirect("home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
