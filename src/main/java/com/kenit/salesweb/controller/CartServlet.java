package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.PurchaseDAOImpl;
import com.kenit.salesweb.model.Purchase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    private PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("cart");
        if (o == null) {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            List<Purchase> purchaseList = purchaseDAO.findAllPurchaseOfUser(customerId);
            session.setAttribute("cart",purchaseList);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/cart.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
