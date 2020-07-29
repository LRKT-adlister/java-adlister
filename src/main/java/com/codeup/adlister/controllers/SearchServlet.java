//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//import com.sun.tools.javac.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//
//@WebServlet("/ad/search")
//    public class SearchServlet extends HttpServlet {
//
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String searching = request.getParameter("search");
//            List<Ad> ads = (List<Ad>) DaoFactory.getAdsDao().all();
//            if (ads.equals(null)) //error if it can't be searched ?
//
////                get a list of all ads in database
//
//        try {
//        List<Ad> adList = DaoFactory.getAdsDao().all(ads);
//        request.setAttribute("ads", DaoFactory.getAdsDao().all(ads));
//    } catch (SQLException se) {
//        se.printStackTrace();
//    }
//        request.getSession().setAttribute("searched", "/ads");
//        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
//}
//
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            request.getSession().setAttribute("searches","/index.jsp");
//            request.getRequestDispatcher()
//
//
//
//    }
//}
//
//
//
