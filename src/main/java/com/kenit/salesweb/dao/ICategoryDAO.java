package com.kenit.salesweb.dao;

import com.kenit.salesweb.model.Category;
import com.kenit.salesweb.model.Product;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAllCategory();

}
