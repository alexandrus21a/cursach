/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mysql.jdbc.Driver
 */
package com.ntu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionFactory {
    public static final String DB_URL = "jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com";
    public static final String DB_USER = "uuintsqhtq0ys6z3";
    public static final String DB_PASSWORD = "bRg0ti2GrMEl0kAyYqU3";

    public static Connection getConnection() {
        try {
            String url = DB_URL;
            String username = DB_USER;
            String password = DB_PASSWORD;
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
