package com.example.helloworld;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "MethodController" , value = "/MethodController")
public class ServletFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getSession().getAttribute("username") == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
