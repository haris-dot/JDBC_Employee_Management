package com.jdbc;

import java.sql.Connection;

public class TestConnection {
	public static void main(String[] args) {
		try {
			
			Connection connection = DBConnection1.getConnection();
			
			System.out.println("Database connected successfully!");
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
