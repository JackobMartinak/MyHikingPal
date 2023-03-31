package com.myhikingpal.model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

        private String DB_URL = "jdbc:sqlite:src/main/java/com/myhikingpal/Db/user.sqlite";    
        // Singleton instance
        private static DbConnection instance;

        // Database connection object
        private Connection connection;
    
        // Private constructor to prevent direct instantiation
        private DbConnection() throws SQLException {
            connection = DriverManager.getConnection(DB_URL);
        }
    
        // Static method to get the singleton instance
        public static DbConnection getInstance() throws SQLException {
            if (instance == null) {
                instance = new DbConnection();
            }
            return instance;
        }
    
        // Method to get the database connection
        public Connection getConnection() {
            return connection;
        }
}
