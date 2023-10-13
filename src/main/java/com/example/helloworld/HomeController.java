package com.example.helloworld;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(description = "HomeController" ,value = "/home")
public class HomeController extends HttpServlet {
    @Resource(name = "jdbc/project")
    private DataSource dataSource;
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        page = page.toLowerCase();
        switch(page){
            case "home" :
                System.out.println("He");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            case "list-users":
                List<User> listUsers = new ArrayList<>();

                try {
                    listUsers = new UsersModel().listUsers(dataSource);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(listUsers);
                    request.setAttribute("listUsers",listUsers);
                    request.getRequestDispatcher("listUser.jsp").forward(request,response);


                break;
            default:
                request.getRequestDispatcher("error.jsp").forward(request,response);
                break;

        }
    }
}
