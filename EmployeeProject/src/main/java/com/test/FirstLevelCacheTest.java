package com.test;

import com.model.CRUD;
import com.pojo.Employee;

public class FirstLevelCacheTest {
 public static void main(String[] args) {
	CRUD crud=new CRUD();
	/*
	Employee emp=new Employee(1,"Om",45000,"ME");
	crud.addEmployee(emp);
	Employee emp2=new Employee(2,"Omprakash",25000,"BE");
	crud.addEmployee(emp2);*/
	Employee emp=crud.getEmployeeById2(2);
	Employee empp=crud.getEmployeeById2(2);
	//System.out.println(emp);
}
}
