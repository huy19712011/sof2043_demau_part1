package com.mycompany.sof2043_demau_part1.dao;

import com.mycompany.sof2043_demau_part1.entity.Product;
import com.mycompany.sof2043_demau_part1.util.XJdbc;
import com.mycompany.sof2043_demau_part1.util.XQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    String FIND_ALL_SQL = "SELECT * FROM products";
    String FIND_BY_ID_SQL = "SELECT * FROM products WHERE id = ?";
    String CREATE_SQL = "INSERT INTO products(id, name, price, categoryId) VALUES(?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE products SET name=?, price=?, categoryId=? WHERE id=?";
    String DELETE_SQL = "DELETE FROM products WHERE id=?";

    String SEARCH_BY_NAME_SQL = "SELECT * FROM products WHERE name LIKE ?";

    public List<Product> findAll() {

        return XQuery.getBeanList(Product.class, FIND_ALL_SQL);
    }

    public Product findById(long id) {

        return XQuery.getSingleBean(Product.class, FIND_BY_ID_SQL, id);
    }

    public Product create(Product e) {

        Object[] values = {
            e.getId(),
            e.getName(),
            e.getPrice(),
            e.getCategoryId()
        };

        XJdbc.executeUpdate(CREATE_SQL, values);

        return e;
    }

    public Product update(Product e) {
        Object[] values = {
            e.getName(),
            e.getPrice(),
            e.getCategoryId(),
            e.getId()
        };

        XJdbc.executeUpdate(UPDATE_SQL, values);

        return e;
    }

    public Product delete(Product e) {
        Object[] values = {
            e.getId()
        };

        XJdbc.executeUpdate(DELETE_SQL, values);

        return e;

    }

    public List<Product> searchByName(String keyword) {

        String[] values = {
            "%" + keyword + "%"
        };
        return XQuery.getBeanList(Product.class, SEARCH_BY_NAME_SQL, values);
    }
}
