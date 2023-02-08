package ibf2022.ssf.day13.repository;

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

    private List<Employee> employees;

    public EmployeeRepo() throws ParseException {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }

        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        Date dt = df.parse("1980-10-15");
        Employee emp = new Employee("Derrick", "Tan", "dt@gmail.com", "9123456", 7500, dt, "10 Ghim Moh", 272210);
        employees.add(emp);

        dt = df.parse("1972-02-18");
        emp = new Employee("DEnnis", "Chew", "dennis@gmail.com", "9234567", 7800, dt, "128Ghim Moh", 272211);
        employees.add(emp);

    }
    

    public List<Employee> findAll() {
        return employees;
    }

    public Boolean save(Employee employee) {
        Boolean result = employees.add(employee);
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


}
