package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.CategoryDAOImpl;
import com.kenit.salesweb.dao.impl.ProductDAOImpl;
import com.kenit.salesweb.model.Category;
import com.kenit.salesweb.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.findALlProduct();
        request.setAttribute("productList",productList);
        List<Category> categoryList = categoryDAO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        Product productLast = productDAO.findNewProduct();
        request.setAttribute("productLast",productLast);
        System.out.println(productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.jsp");
        requestDispatcher.forward(request,response);
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "":
//                break;
//            default:
//                showHomePage(request, response);
//                break;
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
