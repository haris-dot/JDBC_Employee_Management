package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
	public static void main(String[] args) {
		
		String sql = """
				UPDATE employees
				SET salary = ?
				WHERE employee_id = ?
				""";
	
		try (Scanner sc = new Scanner(System.in);
			 Connection connection = DBConnection1.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			
		
			System.out.print("Enter employee_id: ");
			int employeeId = sc.nextInt();
			System.out.print("Enter new salary: ");
			double salary = sc.nextDouble();

			ps.setDouble(1, salary);
			ps.setInt(2, employeeId);

		
			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Salary updated successfully. Rows affected: " + rowsAffected);
			} else {
				System.out.println("No employee found with ID: " + employeeId);
			}

		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}