package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;
import models.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDAO implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDAO(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public Category findUniqueCategoryId(Long category){
        String query = "SELECT * FROM categories WHERE id = ? LIMIT 1";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, category);
            ResultSet rs = stmt.executeQuery();
            if (! rs.next()) {
                return null;
            }
            return extractCategory(rs);
        } catch(SQLException e) {
            throw new RuntimeException("Error finding Ad ID", e);
        }
    }



    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }


    private Category extractCategory(ResultSet rs) throws SQLException {
        if(! rs.next()){
            return null;
        }
        return new Category(
                rs.getInt("id"),
                rs.getString("title")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }
}
