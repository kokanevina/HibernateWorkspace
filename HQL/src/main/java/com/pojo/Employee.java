package com.pojo;

public class Employee {
	private int empId; // mapping to primary key of table
	private String empName;
	private double empSalary;
	private String qualification;
	public Employee() {
		
	}
	
	public Employee(int empId, String empName, double empSalary, String qualification) {
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", qualification="
				+ qualification + "]";
	}
	
	
}
