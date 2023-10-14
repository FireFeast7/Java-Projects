package com.example.helloworld;

import javax.sql.DataSource;
import java.sql.*;
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

    public Boolean addUser(User newUser , DataSource dataSource) throws SQLException {
        Connection connection = null;
        PreparedStatement statement  = null;
        connection = dataSource.getConnection();
        String username = newUser.getUsername();
        String email  = newUser.getEmail();
        String query = "INSERT INTO STUDYEASY (USERNAME,EMAIL) VALUES (?,?)";
        statement = connection.prepareStatement(query);
        statement.setString(1,username);
        statement.setString(2,email);
        return statement.execute();
    }

    public void updateUser(User upUser, DataSource dataSource) throws SQLException {
        Connection connection = null;
        PreparedStatement statement  = null;
        connection = dataSource.getConnection();
        String username = upUser.getUsername();
        int user_id = upUser.getUsers_id();
        String email  = upUser.getEmail();
        String query = "UPDATE STUDYEASY SET USERNAME = ? , EMAIL = ? WHERE USER_ID = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1,username);
        statement.setString(2,email);
        statement.setInt(3,user_id);
        statement.execute();
    }
}
