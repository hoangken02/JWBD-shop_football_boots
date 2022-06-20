package com.kenit.salesweb.model;

public class Category {
    private int categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(int id, String name) {
        this.categoryId = id;
        this.categoryName = name;
    }

    public int getId() {
        return categoryId;
    }

    public void setId(int id) {
        this.categoryId = id;
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name='" + categoryName + '\'' +
                '}';
    }
}
