package com.kenit.salesweb.dao.impl;

import com.kenit.salesweb.dao.IUserDAO;
import com.kenit.salesweb.jdbc.JDBCConnection;
import com.kenit.salesweb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private Connection connection = JDBCConnection.getConnection();
    private static final String LOGIN = "select * from user where userEmail = ? and userPass = ?;";

    private static final String CHECK_EXITED_USER = "select * from user where userEmail = ?;";

    private static final String SIGN_IN = "INSERT INTO user(userEmail,userPass,userRole,userName) VALUES (?,?,?,?);";

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String role = resultSet.getString(4);
                String userName = resultSet.getString(5);
                user = new User(id, email, pass, role, userName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User exitedUser(String userEmail) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EXITED_USER);
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String role = resultSet.getString(4);
                String userName = resultSet.getString(5);
                user = new User(id, email, pass, role, userName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public List<User> listBuyer() {
        return null;
    }

    @Override
    public User findBuyerById(int buyerID) {
        return null;
    }

    @Override
    public void saveBuyer(User buyer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SIGN_IN);
            preparedStatement.setString(1, buyer.getUserEmail());
            preparedStatement.setString(2, buyer.getUserPass());
            preparedStatement.setString(3, buyer.getUserRole());
            preparedStatement.setString(4, buyer.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findBuyerByEmail(String buyerEmail) {
        return null;
    }

    @Override
    public boolean updateUser(User updatedUser) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
       User user = userDAO.exitedUser("ken@gmail.com");
        System.out.println(user.toString());
    }
}
