package com.kenit.salesweb.dao.impl;

import com.kenit.salesweb.dao.IProductDAO;
import com.kenit.salesweb.jdbc.JDBCConnection;
import com.kenit.salesweb.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    private final Connection connection = JDBCConnection.getConnection();

    private static final String SELECT_ALL_PRODUCT = "select * from product;";

    private static final String SELECT_PRODUCT_BY_ID = "select * from product where productID = ?;";

    private static final String FIND_PRODUCT_BY_NAME = "select * from product where productName like ?;";

    private static final String FIND_ALL_PRODUCT_BY_SHOP = "select * from product where shopID = ?;";

    private static final String FIND_PRODUCT_BY_PRICE = "select * from product where productPrice >= ? and productPrice < ?;";

    private static final String SELECT_NEW_PRODUCT = "select * from product order by productID desc LIMIT 1;";

    private static final String SELECT_ALL_PRODUCT_BY_CATEGORY_ID = "select * from product where categoryID = ?;";

    private static final String CREATE_PRODUCT = "INSERT INTO product(productName,productImage,productPrice,productDescription,productQuantity,shopID,categoryID) VALUES (?,?,?,?,?,?,?);";

    private static final String DELETE_PRODUCT = "delete from product where productID = ?;";

    private static final String UPDATE_PRODUCT = "UPDATE product SET productName = ?, productImage = ?,productPrice = ?, productDescription = ?,productQuantity= ?,categoryID = ? WHERE productID = ?;";

    private static final String PAGING = "SELECT * FROM product\n" +
            "order by productID\n" +
            "LIMIT 3 OFFSET ?;";

    private static final String UPDATE_QUANTITY = "update product set productQuantity = ? where productID = ?;";

    @Override
    public List<Product> findALlProduct() {
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);

                productList.add(new Product(pID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public Product findProductById(int id) {
        Product product = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);
                product = new Product(pID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> findProductByPrice(double firstPrice, double secondPrice) {
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_PRICE)) {
            preparedStatement.setDouble(1, firstPrice);
            preparedStatement.setDouble(2, secondPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);

                productList.add(new Product(pID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;

    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);

                productList.add(new Product(pID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean rowUpdate;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductImage());
            preparedStatement.setDouble(3, product.getProductPrice());
            preparedStatement.setString(4, product.getProductDescription());
            preparedStatement.setInt(5, product.getProductQuantity());
            preparedStatement.setInt(6, product.getCategoryID());
            preparedStatement.setInt(7, product.getProductID());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }

    @Override
    public void createProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);

            preparedStatement.executeUpdate();
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductImage());
            preparedStatement.setDouble(3, product.getProductPrice());
            preparedStatement.setString(4, product.getProductDescription());
            preparedStatement.setInt(5, product.getProductQuantity());
            preparedStatement.setInt(6, product.getShopID());
            preparedStatement.setInt(7, product.getCategoryID());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowDelete;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public Product findNewProduct() {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEW_PRODUCT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);
                product = new Product(productID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> findAllProductByShop(int shopId) {
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_PRODUCT_BY_SHOP)) {
            preparedStatement.setInt(1, shopId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);

                productList.add(new Product(pID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<Product> findAllProductByCategoryID(int categoryId) {
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_BY_CATEGORY_ID)) {
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pID = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String productImage = resultSet.getString(3);
                double productPrice = resultSet.getDouble(4);
                String productDescription = resultSet.getString(5);
                int productQuantity = resultSet.getInt(6);
                int shopID = resultSet.getInt(7);
                int categoryID = resultSet.getInt(8);

                productList.add(new Product(pID, productName, productImage, productPrice, productDescription, productQuantity, shopID, categoryID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public boolean updateQuantity(int leftQuantity,int productId) {
        boolean rowUpdate;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY);
            preparedStatement.setInt(1, leftQuantity);
            preparedStatement.setInt(2, productId);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }


    public static void main(String[] args) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        double id = 1;
        double idd = 100;
        String name = "3";
        for (Object o :
                productDAO.findProductByPrice(id, idd)) {
            System.out.println(o);
        }

    }
}
