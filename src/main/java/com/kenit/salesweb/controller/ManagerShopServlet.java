package com.kenit.salesweb.controller;

import com.kenit.salesweb.dao.impl.CategoryDAOImpl;
import com.kenit.salesweb.dao.impl.ProductDAOImpl;
import com.kenit.salesweb.model.Category;
import com.kenit.salesweb.model.Product;
import com.kenit.salesweb.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.List;

@WebServlet(name = "ManagerShopServlet", value = "/shop-manager")
public class ManagerShopServlet extends HttpServlet {
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("acc");
        if (user.getUserRole().equals("shop")) {
            List<Product> productList = productDAO.findAllProductByShop(user.getUserID());
            request.setAttribute("productList", productList);
            List<Category> categoryList = categoryDAO.findAllCategory();
            request.setAttribute("categoryList",categoryList);
            String action = request.getParameter("action");
            System.out.println("action get: "+action);

            if (action == null) {
                action = "";
            }
            switch (action) {
                case "delete":
                    deleteProductView(request,response);
                    break;
                case "edit":
                    editProductView(request,response);
                    break;
                default:
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/manager-product.jsp");
                    requestDispatcher.forward(request, response);
            }

        } else {
            response.sendRedirect("home");
        }

    }

    private void editProductView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findProductById(id);
        request.setAttribute("product",product);
        List<Category> categoryList = categoryDAO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("id",id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/managerBootstrap/crud-product/edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteProductView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/managerBootstrap/crud-product/delete.jsp");
        requestDispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("acc");
        if (user.getUserRole().equals("shop")) {
            List<Product> productList = productDAO.findAllProductByShop(user.getUserID());
            request.setAttribute("productList", productList);
            String action = request.getParameter("action");
            System.out.println("action post: "+action);
            if (action == null) {
                action = "";
            }

            switch (action) {
                case "create":
                    createProduct(request,response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                case "edit":
                    editProduct(request,response);
                    break;
            }

        } else {
            response.sendRedirect("home");
        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int category = Integer.parseInt(request.getParameter("category"));
        Product productUpdate = new Product(productID,name,img,price,description,quantity,category);
        System.out.println(productUpdate);
        productDAO.updateProduct(productUpdate);
        response.sendRedirect("shop-manager");

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        response.sendRedirect("shop-manager");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User userPresent = (User) session.getAttribute("acc");
        int shopId = userPresent.getUserID();
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,img,price,description,quantity,shopId,category);
        productDAO.createProduct(product);
        response.sendRedirect("shop-manager");
    }
}
