//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "EditRedirectServlet", urlPatterns = "/ads/editredirect")
//public class EditRedirectServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.getRequestDispatcher("/WEB-INF/ads/editads.jsp").forward(request,response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        //grab ad by ID from MySqlAdsDao create a method
//////        Long oneAd = Long.parseLong(request.getParameter("singleAd"));
////        Ad singleAd = DaoFactory.getAdsDao().findUniqueAdId(oneAd);
////        System.out.println("singleAd.getTitle() = " + singleAd.getTitle());
////        //ad that gets back set as an attribute do ${};
////        request.setAttribute("singleAd", singleAd);
////
////
////        //======SETTING VALUES IN THE FORM=======//
////        String title = request.getParameter("title");
////        String description = request.getParameter("description");
////
////
////        DaoFactory.getAdsDao().edit(singleAd, title, description);
////        response.sendRedirect("/ads/profile");
//    }
//}
