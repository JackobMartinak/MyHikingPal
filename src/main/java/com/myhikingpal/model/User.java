package com.myhikingpal.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {
    
    private String username;
    private String password;



    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void CreateUser() {
        
        String sql = "INSERT INTO users (name, password, reviews, review_content) VALUES (?, ?, ?, ?)"; 
        try (Connection conn = DbConnection.getInstance().getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, this.username);
            pstmt.setString(2, this.password);
            pstmt.setInt(3, 0);
            pstmt.setString(4, "");

            int insertRows  = pstmt.executeUpdate();

            System.out.println(insertRows + " inserted rows");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean getUser(String username){
        String sql = "SELECT * FROM users WHERE name = ?";
        try  
        {
            Connection conn = DbConnection.getInstance().getConnection();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs  = pstmt.executeQuery();
            if(rs.getString("name") != null && password.equals(rs.getString("password"))){
                
                return true;

            } else {
                System.out.println("Username: " + username + "  Pass: " + password);
                return false;
            }
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
