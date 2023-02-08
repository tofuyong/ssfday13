package ibf2022.ssf.day13.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import ibf2022.ssf.day13.model.Employee;

@Repository    
public class EmployeeRepo {

    final String dirPath = "/Users/andreayong/data";
    final String filename = "employee.txt";

    private List<Employee> employees;

    public EmployeeRepo() throws ParseException {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }

        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        Date dt = df.parse("1980-10-15");
        Employee emp = new Employee("Derrick", "Tan", "derrickt@gmail.com", "9123456", 7500, dt, "10 Ghim Moh", 272210);
        employees.add(emp);

        dt = df.parse("1972-02-18");
        emp = new Employee("Dennis", "Chew", "dennisc@gmail.com", "9234567", 7800, dt, "12 Ghim Moh", 272211);
        employees.add(emp);

    }
    

    public List<Employee> findAll() {
        return employees;
    }

    public Boolean save(Employee employee) throws FileNotFoundException {
        Boolean result = employees.add(employee);

        // to save the file (Java IO)
        File f = new File(dirPath + "/" + filename);
        OutputStream os = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(os);
        pw.println(employee.toString()); //this is not good as it's not comma-delimited, need to ensure it is
        pw.flush();
        pw.close();
    
        return result;
    }
    
    public Boolean delete(Employee employee) {
        // Employee e = employees.stream().filter(emp -> emp.getEmail().equalsIgnoreCase(employee.getEmail())).
        // findFirst().get();

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);
        if (employeeIndex >= 0) {
            employees.remove(employeeIndex);
            result = true;
        }
        return result;
    }

    public Employee findByEmailId(String email) {
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(email)).findFirst().get();

        return emp;
    }


    public Boolean updateEmployee(Employee em) {
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(em.getEmail())).findFirst().get();

        int employeeIndex = employees.indexOf(emp);

        if (employeeIndex >= 0) {
            employees.remove(employeeIndex);
        }

        employees.add(em); //replace with new employee record

        return true;
    }

}
