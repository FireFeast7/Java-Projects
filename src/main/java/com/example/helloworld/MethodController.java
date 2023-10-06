package com.example.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "MethodController" ,  value = "/MethodController")
public class MethodController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "destroy":
                request.getSession().invalidate();
                response.sendRedirect("login.jsp");
                break;
            case "memberArea":
                request.getRequestDispatcher("memberArea.jsp").forward(request,response);
                break;
            case "members-only":
                request.getRequestDispatcher("members-only").forward(request,response);
                break;
            default:
                break;
        }
    }
}
