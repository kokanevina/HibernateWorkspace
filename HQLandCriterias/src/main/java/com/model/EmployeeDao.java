package com.model;
import java.util.List;
import com.pojo.Employee;

public interface EmployeeDao {
		boolean addEmployee(Employee emp);
		List<Employee> getAllEmployees(); 
}
