package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.ServerServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchString = request.getParameter("s");
//      String searchString = request.getParameter("c"); for when we search w/ categories
        try {
            List<Ad> adList = DaoFactory.getAdsDao().searchAds(searchString);
            System.out.println(adList);
            request.setAttribute("ads", adList);
        } catch (SQLException se) {
            se.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}