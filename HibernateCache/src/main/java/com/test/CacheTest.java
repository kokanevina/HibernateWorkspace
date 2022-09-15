package com.test;

import java.util.List;

import com.model.CRUD;
import com.pojo.Employee;

public class CacheTest {
 public static void main(String[] args) throws InterruptedException {
	CRUD crud=new CRUD(); // SessionFactory Object Created
	Employee emp1=crud.getEmployeeById(2); // select
	System.out.println("----------------------------");
	Thread.sleep(1000*20);
	Employee emp2=crud.getEmployeeById(2);
	System.out.println("----------------------------");
	Thread.sleep(1000*20);
	Employee emp3=crud.getEmployeeById(2);
	System.out.println("----------------------------");
	Thread.sleep(1000*20+10);
	Employee emp4=crud.getEmployeeById(2);  // db hit
	System.out.println("----------------------------");
	//System.out.println(emp);
	System.out.println("**************");
	
	List<Employee> elist1= crud.getAllEmployees();
	System.out.println("----------------------------");
	List<Employee> elist2= crud.getAllEmployees();
	
	crud.sfactory.close(); // SessionFactory Object closed
}
}
