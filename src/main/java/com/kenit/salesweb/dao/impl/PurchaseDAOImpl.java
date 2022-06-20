package com.kenit.salesweb.dao.impl;

import com.kenit.salesweb.dao.IPurchaseDAO;
import com.kenit.salesweb.jdbc.JDBCConnection;
import com.kenit.salesweb.model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseDAOImpl implements IPurchaseDAO {
    private Connection connection = JDBCConnection.getConnection();

    private static final String FIND_ALL_PURCHASE_OF_USER = "select * from purchase pc left join product p on pc.productID = p.productId where userId = ?;";

    private static final String EXITED_PRODUCT = "select * from purchase where productID = ? and userId = ?;";

    private static final String CREATE_PURCHASE = "INSERT INTO purchase(productID,shopID,productName,productImage,productPrice,productDescription,userId,purchaseQuantity) VALUES (?,?,?,?,?,?,?,?);";

    private static final String UPDATE_PURCHASE_QUANTITY = "UPDATE purchase SET purchaseQuantity = ? WHERE purchaseID = ?;";

    private static final String DELETE_CART  = "delete from purchase where purchaseID = ?;";

    private static final String ADD_TO_ODER = "delete from purchase where userID = ?";
    @Override
    public List<Purchase> findAllPurchaseOfUser(int userID) {
        List<Purchase> purchaseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_PURCHASE_OF_USER);
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int purchaseID = rs.getInt("purchaseID");
                int productID = rs.getInt("productID");
                int shopID = rs.getInt("shopID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                int uID = rs.getInt("userId");
                int purchaseQuantity = rs.getInt("purchaseQuantity");

                Purchase purchase = new Purchase(purchaseID,
                        productID,
                        shopID,
                        productName,
                        productImage,
                        productPrice,
                        productDescription,
                        uID,
                        purchaseQuantity);
                purchaseList.add(purchase);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchaseList;
    }

    @Override
    public Purchase exitedPurchase(int userID, int productId) {
        Purchase purchase = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EXITED_PRODUCT);
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, userID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int purchaseID = rs.getInt("purchaseId");
                int productID = rs.getInt("purchase.productId");
                int shopID = rs.getInt("shopID");
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                double productPrice = rs.getDouble("productPrice");
                String productDescription = rs.getString("productDescription");
                int uID = rs.getInt("userId");
                int purchaseQuantity = rs.getInt("purchaseQuantity");

                purchase = new Purchase(purchaseID,
                        productID,
                        shopID,
                        productName,
                        productImage,
                        productPrice,
                        productDescription,
                        uID,
                        purchaseQuantity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchase;
    }

    @Override
    public void createPurchase(Purchase purchase) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PURCHASE);
            preparedStatement.setInt(1, purchase.getProductID());
            preparedStatement.setInt(2, purchase.getShopID());
            preparedStatement.setString(3, purchase.getProductName());
            preparedStatement.setString(4, purchase.getProductImage());
            preparedStatement.setDouble(5, purchase.getProductPrice());
            preparedStatement.setString(6, purchase.getProductDescription());
            preparedStatement.setInt(7, purchase.getUserId());
            preparedStatement.setInt(8, purchase.getPurchaseQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateQuantityPurchase(int purchaseQuantity, int purchaseID) {
        boolean rowUpdate;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PURCHASE_QUANTITY);
            preparedStatement.setInt(1, purchaseQuantity);
            preparedStatement.setInt(2, purchaseID);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteCart(int purchaseId) {
        boolean rowCartDelete;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART);
            preparedStatement.setInt(1,purchaseId);
            rowCartDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCartDelete;
    }

    @Override
    public boolean addToOder(int customerID) {
        boolean rowCartDelete;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_TO_ODER);
            preparedStatement.setInt(1,customerID);
            rowCartDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCartDelete;
    }


}
