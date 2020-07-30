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

//    do we need this if we have predefined categories we're going to use? -K
//    @Override
//    public Long insert(Category category) {
//        try {
//            String insertQuery = "INSERT INTO categories(id, title) VALUES (?, ?)";
//            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, category.getId());
//            stmt.setString(2, category.getTitle());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new category.", e);
//        }
//    }

//for finding categories maybe???
    public int findCategoryByName(String title) {
        String query = "SELECT * FROM categories WHERE title = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category by title!", e);
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
