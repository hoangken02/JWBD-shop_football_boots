package com.kenit.salesweb.model;

public class Product {
    private int productID;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;
    private int productQuantity;
    private int shopID;
    private int categoryID;

    public Product() {
    }

    public Product(int productID, String productName, String productImage, double productPrice, String productDescription, int productQuantity, int shopID, int categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.shopID = shopID;
        this.categoryID = categoryID;
    }

    public Product(String name, String img, double price, String description, int quantity,int category) {
        this.productName = name;
        this.productImage = img;
        this.productPrice = price;
        this.productDescription = description;
        this.productQuantity = quantity;
        this.categoryID = category;
    }

    public Product(int productID, String name, String img, double price, String description, int quantity, int category) {
        this.productID = productID;
        this.productName = name;
        this.productImage = img;
        this.productPrice = price;
        this.productDescription = description;
        this.productQuantity = quantity;
        this.categoryID = category;
    }

    public Product(String name, String img, double price, String description, int quantity, int shopId, int category) {
        this.productName = name;
        this.productImage = img;
        this.productPrice = price;
        this.productDescription = description;
        this.productQuantity = quantity;
        this.shopID = shopId;
        this.categoryID = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", productQuantity=" + productQuantity +
                ", shopID=" + shopID +
                ", categoryID=" + categoryID +
                '}';
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
