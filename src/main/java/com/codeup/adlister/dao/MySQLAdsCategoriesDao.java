package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;
import com.codeup.adlister.models.Category;
import models.Config;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsCategoriesDao implements AdsCategories {
    private Connection connection = null;

    public MySQLAdsCategoriesDao(Config config) {
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

    public List<AdCategory> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads_categories");
            ResultSet rs = stmt.executeQuery();
            return createAdsCategoriesFromResults(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving Ads Categories");
        }


    }

    private AdCategory extractAdCategory(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new AdCategory(
                rs.getInt("ad_id"),
                rs.getInt("cat_id")
        );
    }

    private List<AdCategory> createAdsCategoriesFromResults(ResultSet rs) throws SQLException {
        List<AdCategory> AdsCategories = new ArrayList<>();
        while (rs.next()) {
            AdsCategories.add(extractAdCategory(rs));
        }
        return AdsCategories;
    }

    public void insert(long adID, long catID) {
        System.out.println("adID = " + adID);
        System.out.println("catID = " + catID);
        try {
            String insertQuery = "INSERT INTO ads_categories(ad_id, cat_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, adID);
            stmt.setLong(2, catID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating ad category link", e);
        }
    }

}

