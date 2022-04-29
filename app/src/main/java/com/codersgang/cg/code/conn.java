package com.codersgang.cg.code;

import java.sql.*;

public class conn {
    public static void main(String[] args) {
        conn c1 = new conn();
        conn c2 = new conn();
        c1.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
        //c2.connect("jdbc:mysql://localhost/cursach","sanya","1111");
    }

    public static Connection connect(String link, String usr, String pass) {
        try {
            String url = link;
            String username = usr;
            String password = pass;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            System.out.println("Connection to Storage DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return null;
    }
}
