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

@WebServlet(name = "SearchServlet", value = "/search-by-name")
public class SearchByNameServlet extends HttpServlet {
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("productName");
        List<Product> productList = productDAO.findProductByName(name);
        request.setAttribute("productList",productList);
        List<Category> categoryList = categoryDAO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        Product productLast = productDAO.findNewProduct();
        request.setAttribute("productLast",productLast);
        request.setAttribute("names",name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
