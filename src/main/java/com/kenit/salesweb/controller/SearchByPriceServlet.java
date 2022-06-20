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

@WebServlet(name = "SearchByPriceServlet", value = "/search-by-price")
public class SearchByPriceServlet extends HttpServlet {

    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("price");
        String[] prices = price.split(",");
        Double firstPrice = Double.valueOf(prices[0]);
        Double secondPrice = Double.valueOf(prices[1]);
        List<Product> productList = productDAO.findProductByPrice(firstPrice,secondPrice);
        System.out.println(productList);
        request.setAttribute("productList",productList);
        List<Category> categoryList = categoryDAO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        Product productLast = productDAO.findNewProduct();
        request.setAttribute("productLast",productLast);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
