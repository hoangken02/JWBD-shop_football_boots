package com.kenit.salesweb.model;

import java.util.Date;

public class Purchase {
    private  int purchaseID;
    private int productID;
    private int shopID;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int purchaseQuantity;

    public Purchase() {
    }

    public Purchase(int productID, int shopID, String productName, String productImage, double productPrice, String productDescription, int userId, int purchaseQuantity) {
        this.productID = productID;
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.userId = userId;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Purchase(int purchaseID, int productID, int shopID, String productName, String productImage, double productPrice, String productDescription, int purchaseQuantity) {
        this.purchaseID = purchaseID;
        this.productID = productID;
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Purchase(int purchaseID, int productID, int shopID, String productName, String productImage, double productPrice, String productDescription, int userId, int purchaseQuantity) {
        this.purchaseID = purchaseID;
        this.productID = productID;
        this.shopID = shopID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.userId = userId;
        this.purchaseQuantity = purchaseQuantity;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}

