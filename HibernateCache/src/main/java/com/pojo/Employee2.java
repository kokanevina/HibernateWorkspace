package com.pojo;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="employee")
@Cacheable  
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee2 {
	@Id
	@Column(name="emp_id")
	private int empId; // mapping to primary key of table
	@Column(name="emp_name")
	private String empName;
	@Column(name="emp_salary")
	private double empSalary;
	@Column(name="qualification")
	private String qualification;
	public Employee2() {
		
	}
	
	public Employee2(int empId, String empName, double empSalary, String qualification) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.qualification = qualification;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
}
