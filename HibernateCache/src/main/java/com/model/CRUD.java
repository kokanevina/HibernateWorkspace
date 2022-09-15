package com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.db.MyConnection;

import com.pojo.Employee;
import com.pojo.Employee2;
public class CRUD implements  EmployeeDao{
	SessionFactory sfactory;
	public CRUD() {
			sfactory=MyConnection.connect();
			System.out.println("Connection Done.......");
	}
	public boolean addEmployee(Employee em) {
		boolean b=false;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Serializable id= session.save(em); // insert query  // persists
		tr.commit();
		b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	/*1st level cache wont work for HQL : bcz we are explicitly telling hibernate to fire SQL on database*/
	public List<Employee>  getAllEmployees() 
	{ 
		List<Employee> empList1=null,empList2=null;
		Session session=sfactory.openSession(); // session opened
		
			Transaction tr=session.beginTransaction();
			TypedQuery<Employee> query1=session.createQuery("from Employee", Employee.class); // HQL 
			empList1= query1.getResultList();
			TypedQuery<Employee> query2=session.createQuery("from Employee", Employee.class); // HQL 
			empList2= query2.getResultList();
			tr.commit();
			session.close(); // session closed
			return empList2;
	}
	
	 public Employee getEmployeeById(int empId) 
	  {  Employee emp1=null,emp2=null;
		  // if we want to select record on the basis of pk then direct method : get is available
		  try(Session session=sfactory.openSession();){ // session opened 
			Transaction tr=session.beginTransaction();
		    emp1=session.get(Employee.class, empId);// select emp_id,emp_name, emp_salary, qualification from employee where emp_id=?
		    emp2=session.get(Employee.class, empId); // data from cache
			tr.commit();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		  // session autoclosed, cache cleared
		  return emp2;
	  }
} // method ended
	  
	  
	  
	  
	 
	
	
	
	

