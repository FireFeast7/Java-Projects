package com.example.helloworld;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/Demo2"} , initParams = {@WebInitParam(name = "message2" , value = "initialization from annotation ", description = "yo")})
public class Demo2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletConfig config = getServletConfig();
        String message = config.getInitParameter("message2");
        response.getWriter().println(message);
    }
}
