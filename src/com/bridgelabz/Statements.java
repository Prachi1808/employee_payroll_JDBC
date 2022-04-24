package com.bridgelabz;
import java.sql.*;
import java.util.ArrayList;

public class Statements 
{
/**
 * Retrive query - string containing query to retrieve table rows
 * Update query  - string containing query to update salary
 * connection    - instance of connection interface
 * payrollarraylist -arraylist of employeepayroll type
 */
	
	
	public final static String RETRIEVE_QUERY = "SELECT * from employee_payroll";
	public final static String UPDATE_QUERY = "UPDATE employee_payroll SET Salary = 5000000 WHERE name = 'Prachi'";
	public final static String PREPARED_UPDATE_QUERY = "UPDATE employee_payroll SET Salary = ? WHERE name = ?;";
	public final static String PREPARED_RETRIEVE_QUERY = "SELECT Name, Start_Date FROM employee_payroll WHERE Start_Date Between CAST(? AS DATE) AND CAST(? AS DATE));";
	    Connection connection;
	    ArrayList<EmployeePayrollJDBCMain> payrollArrayList;

	    
	    public Statements(Connection connection) {
	        this.connection = connection;
	    }
	    public <payrollArrayList> void retrievePayroll() throws CustomException {

	        payrollArrayList = EmployeeDatabase.getEmployeeDB();
	        Statement statement;

	        try {
	            statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(RETRIEVE_QUERY);

	            while (resultSet.next()) {
	            	EmployeePayrollJDBCMain employeePayroll = new EmployeePayrollJDBCMain ();
	                payrollArrayList.add(employeePayroll);
	                System.out.println(employeePayroll);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public boolean updatePayroll() throws CustomException, SQLException {

	        payrollArrayList = EmployeeDatabase.getEmployeeDB();
	        Statement statement;

	        statement = connection.createStatement();
	        statement.execute(UPDATE_QUERY);
	        for (EmployeePayrollJDBCMain employeePayroll : payrollArrayList) {
	            if (employeePayroll.getName().equals("Prachi"))
	            {
	                employeePayroll.setSalary(5000000);
	                return true;
	            }
	        }

	        return false;
	    }
	    public boolean updateByPreparedStatement() throws CustomException, SQLException {

	        payrollArrayList = EmployeeDatabase.getEmployeeDB();
	        PreparedStatement preparedStatement;

	        preparedStatement = connection.prepareStatement(PREPARED_UPDATE_QUERY);
	        preparedStatement.setInt(1, 50000);
	        preparedStatement.setString(2, "Prachi");
	        preparedStatement.execute();

	        for (EmployeePayrollJDBCMain employeePayroll : payrollArrayList) {
	            if (employeePayroll.getName().equals("Prachi")) {
	                employeePayroll.setSalary(50000);
	                return true;
	            }
	        }
	        return false;

	    }
	    public boolean retrieveEmployeeByStartDate(String date1, String date2) throws CustomException, SQLException {

	        String query = String.format("SELECT * FROM employee_payroll where Start_Date between '%s' AND '%s';", date1, date2);
	        payrollArrayList = EmployeeDatabase.getEmployeeDB();
	        Statement statement;
	        statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	        	EmployeePayrollJDBCMain employeePayroll = new EmployeePayrollJDBCMain (resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8), resultSet.getDouble(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13));
	            payrollArrayList.add(employeePayroll);
	            System.out.println(employeePayroll);
	            return true;
	        }
	        return false;

	    }
	}
	    

	