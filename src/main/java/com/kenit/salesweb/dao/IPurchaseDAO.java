package com.kenit.salesweb.dao;

import com.kenit.salesweb.model.Purchase;

import java.util.List;

public interface IPurchaseDAO {
    List<Purchase> findAllPurchaseOfUser(int userID);

    Purchase exitedPurchase(int userID,int productID);

    void createPurchase(Purchase purchase);

    boolean updateQuantityPurchase(int purchaseQuantity,int purchaseID);

    boolean deleteCart(int purchaseId);

    boolean addToOder(int customerID);
}
