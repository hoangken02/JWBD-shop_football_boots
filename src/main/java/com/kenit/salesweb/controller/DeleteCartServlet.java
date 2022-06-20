package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.PurchaseDAOImpl;
import com.kenit.salesweb.model.Purchase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteCartServlet", value = "/delete-cart")
public class DeleteCartServlet extends HttpServlet {
    private PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));
        purchaseDAO.deleteCart(purchaseId);
        HttpSession session = request.getSession();
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        List<Purchase> purchaseList = purchaseDAO.findAllPurchaseOfUser(customerID);
        session.setAttribute("cart",purchaseList);
        response.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
