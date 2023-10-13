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

@WebServlet(description = "HomeController" ,value = "/operation")
public class HomeController extends HttpServlet {
    @Resource(name = "jdbc/project")
    private DataSource dataSource;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        page = page.toLowerCase();
        switch (page) {
            case "list-users":
                listUsers(request,response);
                break;
            case "add-user":
                addUser(request,response);
                break;

        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String form = request.getParameter("form");
        form = form.toLowerCase();
        switch (form){
            case "add-userops":
            User newUser = new User(request.getParameter("username"),request.getParameter("email"));
                try {
                    addUserOperation(newUser);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
                request.getRequestDispatcher("error.jsp").forward(request, response);
                request.setAttribute("title", "ErrorPage");
                break;
        }
    }

    private void addUserOperation(User newUser) throws SQLException {
        new UsersModel().addUser(newUser , dataSource);
        return;
    }

    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUsers = new ArrayList<>();

        try {
            listUsers = new UsersModel().listUsers(dataSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(listUsers);
        request.setAttribute("listUsers", listUsers);
        request.setAttribute("title", "List Of Users");
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addUser.jsp").forward(request, response);
    }


}
