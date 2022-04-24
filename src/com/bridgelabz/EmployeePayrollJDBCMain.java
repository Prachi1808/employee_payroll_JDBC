package com.bridgelabz;
import java.lang.module.Configuration;
import java.sql.SQLException;

/**
 * main method.
 * @author ppmoh
 *
 */


public class EmployeePayrollJDBCMain 
{

	/**
	 * main method.
	 * create conf obj- configuration
	 * create a statement obj using conf establish connection method
	 * call retrievepayrol method for statment obj to print table rows to console
	 * call updated payroll method to update table row 
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, CustomException{
		
		Configuration configuration = new Configuration();
        Statements statements = new Statements(configuration.establishConnection());
        statements.retrievePayroll();
        statements.updatePayroll();
        statements.updateByPreparedStatement();
        statements.retrieveEmployeeByStartDate("2022-01-01", "2022-03-02");
	}

}
