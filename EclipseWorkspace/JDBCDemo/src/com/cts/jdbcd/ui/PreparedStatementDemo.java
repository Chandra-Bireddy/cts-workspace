package com.cts.jdbcd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		
		try(
				Scanner scan = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","welcome");
				){
			String jobId, jobTitle;
			System.out.println("Enter job id:");
			jobId = scan.next();
			System.out.println("Enter job title:");
			jobTitle= scan.next();
			
			String sql = "UPDATE employee SET empname =? WHERE empid=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, jobTitle);
			ps.setString(2,jobId);
			
			ps.executeUpdate();
			System.out.println("Row updated.");
		}catch(SQLException e) {
			System.err.println("Could not update");
			e.printStackTrace();
		}

	}

}
