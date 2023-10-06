package com.example.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Controller" , value = "/Controller")
public class Controller extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String param = request.getParameter("page");
        if(param.equals("login")){
            getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        } else if (param.equals("about-us")) {
            getServletContext().getRequestDispatcher("/About%20Us.jsp").forward(request , response);
        } else if (param.equals("signup")) {
           // response.sendRedirect("signup.jsp");
            getServletContext().getRequestDispatcher("/signup.jsp").forward(request,response);
        }else if(param.equals("members-only")){
            getServletContext().getRequestDispatcher("/members-only.jsp").forward(request,response);
        }
        else{
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request,response);
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String param = request.getParameter("action");
        switch (param){
            case "loginSubmit":
            authenticate(request,response);
        }
    }
    public void authenticate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("Ameya") && password.equals("Surana")){
            request.getSession().invalidate();
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(300);
            newSession.setAttribute("username",username);
            String encode = response.encodeURL(request.getContextPath());
            response.sendRedirect(encode+"/MethodController?action=memberArea");
        }
        else{
            getServletContext().getRequestDispatcher("notFound.jsp").forward(request,response);
        }
    }
}
