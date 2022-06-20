package com.kenit.salesweb.dao;

import com.kenit.salesweb.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findALlProduct();

    Product findProductById(int id);

    List<Product> findProductByPrice(double firstPrice,double secondPrice);

    List<Product> findProductByName(String name);

    boolean updateProduct(Product product);

    void createProduct(Product product);

    boolean deleteProduct(int id);

    Product findNewProduct();

    List<Product> findAllProductByShop(int shopId);

    List<Product> findAllProductByCategoryID(int categoryId);

    boolean updateQuantity(int leftQuantity,int productID);
}
