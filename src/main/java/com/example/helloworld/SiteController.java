package com.example.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Site",value = "/site")
public class SiteController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        page = page.toLowerCase();
        switch (page) {
            case "home":
                homepage(request, response);
                break;
            default:

                request.getRequestDispatcher("error.jsp").forward(request, response);
                request.setAttribute("title", "ErrorPage");
                break;
        }
    }
        public void homepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            request.setAttribute("title", "HomePage");
        }
}
