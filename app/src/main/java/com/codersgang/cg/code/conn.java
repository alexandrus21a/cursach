package com.codersgang.cg.code;

import java.sql.*;

public class conn {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/cursach";
            String username = "sanya";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            System.out.println("Connection to Store DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
