package com.mycompany.sof2043_demau_part1;

import com.mycompany.sof2043_demau_part1.util.XJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sof2043_demau_part1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        /*
        CREATE TABLE categories(
        id BIGINT PRIMARY KEY,
        name NVARCHAR(30) NOT NULL
        );

        CREATE TABLE products(
        id BIGINT PRIMARY KEY,
        name NVARCHAR(30) NOT NULL,
        price FLOAT NOT NULL,
        categoryId BIGINT NOT NULL,
        FOREIGN KEY (categoryId) REFERENCES categories(id)
        );
         */
//        String sql = """
//                        CREATE TABLE categories(
//                        id BIGINT PRIMARY KEY,
//                        name NVARCHAR(30) NOT NULL
//                        );
//                     """;
        String sql = """
                        INSERT INTO categories(id, name)
                        VALUES(?, ?);
                     """;
        XJdbc.executeUpdate(sql, 1, "Category 1");
        XJdbc.executeUpdate(sql, 2, "Category 2");
        XJdbc.executeUpdate(sql, 3, "Category 3");

        String sql2 = """
                         INSERT INTO products(id, name, price, categoryId)
                         VALUES(?, ?, ?, ?);
                      """;
        XJdbc.executeUpdate(sql2, 1, "Product 1", 11.9, 1);
        XJdbc.executeUpdate(sql2, 2, "Product 2", 12.9, 2);
        XJdbc.executeUpdate(sql2, 3, "Product 3", 13.9, 3);
        XJdbc.executeUpdate(sql2, 4, "Product 4", 14.9, 1);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;

                try {

            connection = XJdbc.openConnection();
            System.out.println("Connected...");

            String sql3 = """
                            SELECT * FROM products;
                         """;

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql3);

            while (resultSet.next()) {
                System.out.println("Product Id: " + resultSet.getInt("id"));
                System.out.println("Product Name: " + resultSet.getString("name"));
                System.out.println("Product Price: " + resultSet.getBigDecimal("price"));
                System.out.println("Product Category Id: " + resultSet.getInt("categoryId"));
            }


            System.out.println("done...");

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            // close connection, prepatedStatement, resulSet
        }
    }
}
