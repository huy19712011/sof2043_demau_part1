package com.mycompany.sof2043_demau_part1.dao;

import com.mycompany.sof2043_demau_part1.entity.Category;
import com.mycompany.sof2043_demau_part1.util.XJdbc;
import com.mycompany.sof2043_demau_part1.util.XQuery;
import java.util.List;

public class CategoryDao {

    String FIND_ALL_SQL = "SELECT * FROM categories";
    String FIND_BY_ID_SQL = "SELECT * FROM categories WHERE id = ?";
    String CREATE_SQL = "INSERT INTO categories(id, name) VALUES(?, ?)";
    String UPDATE_SQL = "UPDATE categories SET name=? WHERE id=?";
    String DELETE_SQL = "DELETE FROM categories WHERE id=?";

    public List<Category> findAll() {

        return XQuery.getBeanList(Category.class, FIND_ALL_SQL);
    }

    public Category findById(long id) {

        return XQuery.getSingleBean(Category.class, FIND_BY_ID_SQL, id);
    }

    public Category create(Category e) {

        Object[] values = {
            e.getId(),
            e.getName()
        };

        XJdbc.executeUpdate(CREATE_SQL, values);

        return e;
    }

    public Category update(Category e) {
        Object[] values = {
            e.getName(),
            e.getId()
        };

        XJdbc.executeUpdate(UPDATE_SQL, values);

        return e;
    }

    public Category delete(Category e) {
        Object[] values = {
            e.getId()
        };

        XJdbc.executeUpdate(DELETE_SQL, values);

        return e;

    }
}
