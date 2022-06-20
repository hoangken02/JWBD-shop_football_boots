package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.CategoryDAOImpl;
import com.kenit.salesweb.dao.impl.ProductDAOImpl;
import com.kenit.salesweb.model.Category;
import com.kenit.salesweb.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findProductById(id);
        request.setAttribute("product",product);
        List<Category> categoryList = categoryDAO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        Product productLast = productDAO.findNewProduct();
        request.setAttribute("productLast",productLast);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showProductDetailsHomepage.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
