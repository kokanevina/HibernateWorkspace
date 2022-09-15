package com.test;

import com.model.CRUD;
import com.pojo.Employee;

public class CacheTest {
 public static void main(String[] args) {
	CRUD crud=new CRUD(); // SessionFactory Object Created 
	/*
	Employee emp=new Employee(1,"Om",45000,"ME");
	crud.addEmployee(emp);
	Employee emp2=new Employee(2,"Omprakash",25000,"BE");
	crud.addEmployee(emp2);*/
	
	Employee emp=crud.getEmployeeById(2); // select
	System.out.println("________________________");
	Employee empp=crud.getEmployeeById(2);
	//System.out.println(emp);
	crud.sfactory.close(); // SessionFactory Object closed
}
}
