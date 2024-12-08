package com.maven.practice.Maven_project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateOperation {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june24","root","sanjith");
			System.out.println("Connection Established");
			
			String sql = "insert into result value(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			System.out.println("Statement Prepared");
			
			System.out.println("Enter the number of rows to insert");
			int rows = sc.nextInt();
			
			for(int i=0;i<rows;i++) {
				System.out.println("Enter ID, Name, m1, m2, m3, m4");
				int id = sc.nextInt();
				String name = sc.next();
				int m1 = sc.nextInt();
				int m2 = sc.nextInt();
				int m3= sc.nextInt();
				int m4 = sc.nextInt();
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, m1);
				ps.setInt(4, m2);
				ps.setInt(5, m3);
				ps.setInt(6, m4);
				ps.addBatch();
			}
			
			int res[] = ps.executeBatch();
			System.out.println("Query Executed");
			
			for(int i:res) {
				System.out.print(i+"    ");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			con.close();
			ps.close();
			sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
