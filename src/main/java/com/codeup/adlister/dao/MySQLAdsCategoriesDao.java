package com.codeup.adlister.dao;

import models.Config;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.SQLException;

//public class MySQLAdsCategoriesDao implements AdsCategories {
//    private Connection connection = null;
//
//    public MySQLAdsCategoriesDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUser(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//    }
//
//}
