package com.bridgelabz;

import java.util.ArrayList;

/**
 * Class containing ArrayList of EmployeePayroll Type - employeeDB. & method to return the same ArrayList.
 *
 * @author ppmoh
 */
public class EmployeeDatabase {
    /**
     * Arraylist of EmployeePayroll Type - employeeDB.
     */
    static ArrayList<EmployeePayrollJDBCMain> employeeDB = new ArrayList<>();

    /**
     * Method to getEmployeeDB.
     *
     * @return - employeeDB.
     */
    public static ArrayList<EmployeePayrollJDBCMain> getEmployeeDB() {
        return employeeDB;
    }
}
