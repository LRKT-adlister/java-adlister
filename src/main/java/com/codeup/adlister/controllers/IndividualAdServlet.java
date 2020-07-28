package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndividualAdServlet", urlPatterns = "/ads/single")
public class IndividualAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //grab ad by ID from MySqlAdsDao create a method
        Long oneAd = Long.parseLong(request.getParameter("singleAd"));
        Ad singleAd = DaoFactory.getAdsDao().findUniqueAdId(oneAd);
        //ad that gets back set as an attribute do ${};

        System.out.println(singleAd.getTitle());

        request.getRequestDispatcher("/WEB-INF/ads/single.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
