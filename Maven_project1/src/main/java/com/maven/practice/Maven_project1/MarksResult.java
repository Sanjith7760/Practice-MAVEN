package com.maven.practice.Maven_project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MarksResult {

	public static void main(String[] args) {
		Connection con =null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	Scanner sc = new Scanner(System.in);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("Driver Loaded");
        	
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
        	System.out.println("Connection Established");
        	
        	String sql = "Select * from result where id=?";
        	ps = con.prepareStatement(sql);
        	System.out.println("Statement Prepared");
        	
        	System.out.println("Enter the Id of the student");
        	int rollno = sc.nextInt();
        	ps.setInt(1, rollno);
        	
        	rs=ps.executeQuery();
        	while(rs.next()) {
        		int id = rs.getInt(1);
        		String name = rs.getString(2);
        		int m1 = rs.getInt(3);
        		int m2 = rs.getInt(4);
        		int m3 = rs.getInt(5);
        		int m4 = rs.getInt(6);
        		
        		int total = m1+m2+m3+m4;
        		float fraction = (float)total/400;
        		float percent = fraction * 100;
        		
        		System.out.println(id+"   "+name+"   "+m1+"   "+m2+"   "+m3+"   "+m4+"   "+percent);
        	}
        }
		catch(Exception e) {
			e.printStackTrace();
		}
        finally {
        	try {
        	con.close();
        	ps.close();
        	rs.close();
        	sc.close();
        	}
        	catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
}
