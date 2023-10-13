package com.example.helloworld;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class UsersModel {

    public List<User> listUsers(DataSource source) throws SQLException {
        List<User> listUsers = new ArrayList<>();

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        connection = source.getConnection();
        String query = "SELECT * FROM studyeasy";
        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()){
            listUsers.add(new User(rs.getInt("user_id"),rs.getString("username"),rs.getString("email")));
        }
        return listUsers;

    }
}
