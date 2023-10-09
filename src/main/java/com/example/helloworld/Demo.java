package com.example.helloworld;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.annotation.Resource;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;
@WebServlet(name = "Database" , value = "/Demo")
public class Demo extends HttpServlet {
    @Resource(name = "jdbc/project")
    private DataSource dataSource;
    @Override
    public void init() throws ServletException {
        super.init();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Connection connection = null;
            Statement stmt = null;
            ResultSet rs = null;
            PrintWriter out = response.getWriter();
            connection = dataSource.getConnection();
            String query = "SELECT * FROM studyeasy";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                out.println("<br/>"+rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
