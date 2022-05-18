package com.cg.code;

import com.cg.code.PFA.carPFAImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    private static final String DB_URL = "jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com";
    private static final String DB_USER = "uuintsqhtq0ys6z3";
    private static final String DB_PASSWORD = "bRg0ti2GrMEl0kAyYqU3";

    public static void main(String[] args) {
        carPFAImpl c1 = new carPFAImpl();
        conn c2 = new conn();
        connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
        //c2.connect("jdbc:mysql://localhost/cursach","sanya","1111");
        c2.getConnection();
        c1.findcar("Bmw");
    }
    public static Connection getConnection() {
        try {
            String url = DB_URL;
            String username = DB_USER;
            String password = DB_PASSWORD;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            System.out.println("Connection to test DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return null;
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
