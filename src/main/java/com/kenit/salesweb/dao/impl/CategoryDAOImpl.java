package com.kenit.salesweb.dao.impl;

import com.kenit.salesweb.dao.ICategoryDAO;
import com.kenit.salesweb.jdbc.JDBCConnection;
import com.kenit.salesweb.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {

    private final String SELECT_ALL_CATEGORY = "select categoryId,categoryName from category;";
    Connection connection = JDBCConnection.getConnection();
    @Override
    public List<Category> findAllCategory() {
       List<Category> categoryList = new ArrayList<>();
       try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)){
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()){
               int id = resultSet.getInt(1);
               String name = resultSet.getString(2);
               categoryList.add(new Category(id,name));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return categoryList;
    }

    public static void main(String[] args) {
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        List<Category> categoryList = categoryDAO.findAllCategory();
        for (Object o:
             categoryList) {
            System.out.println(o);
        }
    }
}
