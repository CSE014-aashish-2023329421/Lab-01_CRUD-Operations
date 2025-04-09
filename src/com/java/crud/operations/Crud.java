package com.java.crud.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "SACHIN9838a");
            System.out.println("Connected");
            
            stmt = con.createStatement();

            // Insert operation (Fix column name)
            stmt.executeUpdate("INSERT INTO employee (`System Id`, Name, Course) VALUES (2, 'Aashish', 'B.Tech')");

            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM employee");

            
            while (rs.next()) {
                int id = rs.getInt("System Id");  
                String name = rs.getString("Name");
                String course = rs.getString("Course");

                System.out.println("System Id: " + id + ", Name: " + name + ", Course: " + course);
            }

        } catch (Exception e) {
            e.printStackTrace();
       
            }
        }
    }

