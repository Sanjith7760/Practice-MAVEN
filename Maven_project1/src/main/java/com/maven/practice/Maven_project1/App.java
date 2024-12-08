package com.maven.practice.Maven_project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
    	Connection con =null;
    	Statement stmt = null;
    	ResultSet rs = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("Driver Loaded");
        	
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
        	System.out.println("Connection Established");
        	
        	String sql = "Select * from batches";
        	stmt = con.createStatement();
        	System.out.println("Statement Created");
        	
        	rs = stmt.executeQuery(sql);
        	System.out.println("Query Executed");
        	
        	System.out.println("ID"+"  |  "+"Name"+"  |  "+"Marks");
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+"      "+rs.getString(2)+"     "+rs.getInt(3));
        	}
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        finally {
        	try {
        	con.close();
        	stmt.close();
        	rs.close();
        	}
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
}
