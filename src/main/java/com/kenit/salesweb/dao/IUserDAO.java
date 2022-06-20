package com.kenit.salesweb.dao;

import com.kenit.salesweb.model.User;

import java.util.List;

public interface IUserDAO {

    User login(String username,String password);

    User exitedUser(String userEmail);

    List<User> listUser();

    List<User> listBuyer();

    User findBuyerById(int buyerID);

    void saveBuyer(User buyer);

    User findBuyerByEmail(String buyerEmail);

    boolean updateUser(User updatedUser);

    boolean deleteUser(int id);
}
