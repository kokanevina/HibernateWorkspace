package com.test;

import java.util.List;

import com.model.CRUD;
import com.pojo.Employee;

public class CacheTest {
 public static void main(String[] args) {
	CRUD crud=new CRUD(); // SessionFactory Object Created
	Employee emp=crud.getEmployeeById(2); // select
	System.out.println("----------------------------");
	Employee empp=crud.getEmployeeById(2);
	//System.out.println(emp);
	System.out.println("**************");
	
	List<Employee> elist1= crud.getAllEmployees();
	System.out.println("----------------------------");
	List<Employee> elist2= crud.getAllEmployees();
	
	crud.sfactory.close(); // SessionFactory Object closed
}
}
