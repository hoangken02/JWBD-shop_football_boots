package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.ProductDAOImpl;
import com.kenit.salesweb.dao.impl.PurchaseDAOImpl;
import com.kenit.salesweb.model.Product;
import com.kenit.salesweb.model.Purchase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuyProductServlet", value = "/buy-product")
public class BuyProductServlet extends HttpServlet {
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID;
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int quantity = 1;
        int leftQuantity;
        if (request.getRequestDispatcher("productID") != null) {
            productID = Integer.parseInt(request.getParameter("productID"));
            Product product = productDAO.findProductById(productID);
            if (product.getProductQuantity() <= 0) {
                response.sendRedirect("home");
            }
            HttpSession session = request.getSession();
            List<Purchase> purchaseListCheck = purchaseDAO.findAllPurchaseOfUser(customerId);
            session.setAttribute("cart",purchaseListCheck);
            Object o = session.getAttribute("cart");
            System.out.println(o);
            if (o == null) {
                    Purchase purchase = new Purchase(
                            product.getProductID(),
                            product.getShopID(),
                            product.getProductName(),
                            product.getProductImage(),
                            product.getProductPrice(),
                            product.getProductDescription(),
                            customerId,
                            quantity);
                    purchaseDAO.createPurchase(purchase);
                    leftQuantity = product.getProductQuantity() - quantity;
                    productDAO.updateQuantity(leftQuantity,product.getProductID());
                    List<Purchase> purchaseList = purchaseDAO.findAllPurchaseOfUser(customerId);
                    session.setAttribute("cart",purchaseList);
                    session.setMaxInactiveInterval(60 * 60 * 24);
            }else {
                Purchase purchaseExited = purchaseDAO.exitedPurchase(customerId,productID);
                if (purchaseExited == null){
                    Purchase purchase = new Purchase(
                            product.getProductID(),
                            product.getShopID(),
                            product.getProductName(),
                            product.getProductImage(),
                            product.getProductPrice(),
                            product.getProductDescription(),
                            customerId,
                            quantity);
                    purchaseDAO.createPurchase(purchase);
                    leftQuantity = product.getProductQuantity() - quantity;
                    productDAO.updateQuantity(product.getProductID(),leftQuantity);
                    List<Purchase> purchaseList = purchaseDAO.findAllPurchaseOfUser(customerId);
                    session.setAttribute("cart",purchaseList);
                }else {
                    quantity = purchaseExited.getPurchaseQuantity() + 1;
                    purchaseDAO.updateQuantityPurchase(quantity,purchaseExited.getPurchaseID());
                    leftQuantity = product.getProductQuantity() - 1;
                    productDAO.updateQuantity(leftQuantity,product.getProductID());
                    List<Purchase> purchaseList = purchaseDAO.findAllPurchaseOfUser(customerId);
                    session.setAttribute("cart",purchaseList);
                    session.setMaxInactiveInterval(60 * 60 * 24);
                }
            }
        }

        request.getRequestDispatcher("view/cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
