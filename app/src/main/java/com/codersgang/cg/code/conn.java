package com.codersgang.cg.code;

import java.sql.*;

public class conn {
    public static void main(String[] args){
        conn c = new conn();
        conn c2 = new conn();
        c.connect("jdbc:mysql://localhost/cursach","","");
        //c2.connect("jdbc:mysql://localhost/cursach","sanya","1111");
    }
    public static void connect(String link, String usr, String pass){
        try {
            String url = link;
            String username = usr;
            String password = pass;
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
