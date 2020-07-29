package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        if(request.getSession().setAttribute("Ad", ))

//
        Long oneAd = Long.parseLong(request.getParameter("singleAd"));
        Ad singleAd = DaoFactory.getAdsDao().findUniqueAdId(oneAd);

        request.setAttribute("existingTitle", singleAd.getTitle());
        request.setAttribute("existingDescription", singleAd.getDescription());


        //grab ad by ID from MySqlAdsDao create a method
//        Long oneAd = Long.parseLong(request.getParameter("singleAd"));
//
//            Ad singleAd = DaoFactory.getAdsDao().findUniqueAdId(oneAd);
//            System.out.println("singleAd.getTitle() = " + singleAd.getTitle());
//            //ad that gets back set as an attribute do ${};
//            request.setAttribute("singleAd", singleAd);
//            request.setAttribute("existingTitle", singleAd.getTitle());
//            request.setAttribute("existingDescription", singleAd.getDescription());
//
//            //======SETTING VALUES IN THE FORM=======//
//            String title = request.getParameter("title");
//            String description = request.getParameter("description");
//
//
//            DaoFactory.getAdsDao().edit(singleAd, title, description);
//            response.sendRedirect("/ads/profile");
//
            request.getRequestDispatcher("/WEB-INF/ads/editads.jsp").forward(request, response);


//        Ad singleAd = DaoFactory.getAdsDao().findUniqueAdId(oneAd);
//        System.out.println("singleAd.getTitle() = " + singleAd.getTitle());
//        //ad that gets back set as an attribute do ${};
//        request.setAttribute("singleAd", singleAd);
//        request.setAttribute("existingTitle", singleAd.getTitle());
//        request.setAttribute("existingDescription", singleAd.getDescription());
//
//        //======SETTING VALUES IN THE FORM=======//
//        String title = request.getParameter("title");
//        String description = request.getParameter("description");
//
//
//        DaoFactory.getAdsDao().edit(singleAd, title, description);
//        response.sendRedirect("/ads/profile");
//
//        request.getRequestDispatcher("/WEB-INF/ads/editads.jsp").forward(request, response);

//        Long editAd = Long.parseLong(request.getParameter("editSingleAd"));
//        Long editSingleAd = DaoFactory.getAdsDao().edit(editAd);
        //editing ad right here

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {




        Long oneAd = Long.parseLong(request.getParameter("singleAd"));

        Ad singleAd = DaoFactory.getAdsDao().findUniqueAdId(oneAd);

        System.out.println("singleAd = " + singleAd);
        System.out.println("oneAd = " + oneAd);

        request.setAttribute("existingTitle", singleAd.getTitle());
        request.setAttribute("existingDescription", singleAd.getDescription());
        //grab ad by ID from MySqlAdsDao create a method

        System.out.println("singleAd.getTitle() = " + singleAd.getTitle());
        //ad that gets back set as an attribute do ${};
        request.setAttribute("singleAd", singleAd);
        request.setAttribute("existingTitle", singleAd.getTitle());
        request.setAttribute("existingDescription", singleAd.getDescription());


        //======SETTING VALUES IN THE FORM=======//
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if(request.getParameter("adToUpdate").equalsIgnoreCase("true")) {
            DaoFactory.getAdsDao().edit(singleAd, title, description);
            response.sendRedirect("/profile");
        }
    }
}
