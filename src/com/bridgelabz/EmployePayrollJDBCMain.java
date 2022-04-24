package com.bridgelabz;

	import java.sql.DriverManager;
	import java.sql.SQLException;

	/**
	 * Class containing logic to establish mysql database connection.
	 */
	
	public class EmployePayrollJDBCMain {

	    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	        try {
	            /**
	             * Creating instance of Driver Class.
	             */
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver loaded");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Driver not loaded");
	        }

	        String url = "jdbc:mysql://localhost:3306/payroll_service";
	        try {
	            /**
	             * Establishing Connection using URL and Credintials of mysql database.
	             */
	            DriverManager.getConnection(url, "root", "Prachi@1808");
	            System.out.println("Connection established");
	        } catch (SQLException e) {
	            System.out.println("Connection not established");
	        }

	    }
	}