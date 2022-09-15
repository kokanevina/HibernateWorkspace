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
public class CRUD  implements EmployeeDao{
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
	
	  public boolean updateEmployee(Employee em) {
		  boolean b=false;
			try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			session.update(em); // id : existing, other : new/old
			b=true;
			tr.commit();		
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return b;
	  } 
	  
	 
	  public boolean deleteEmployee(int empId) { 
		  
		  boolean b=false;
			try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			Employee emp=session.get(Employee.class, empId);
			session.delete(emp);
			tr.commit();
			b=true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return b;
		  
	  }
	  
	  
	 
	  public Employee getEmployeeById(int empId) 
	  {  Employee emp=null;
		  // if we want to select record on the basis of pk then direct method : get is available
		  try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
		    emp=session.get(Employee.class, empId);// ORM
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		  return emp;
	  }
	  
	
	public List<Employee> getAllEmployees() 
	{ 
		List<Employee> empList=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			TypedQuery<Employee> query=session.createQuery("from Employee", Employee.class); //Hibernate Query Lan
			empList= query.getResultList();
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return empList;
	}
	
	
	
	public boolean addEmployee(Employee2 em) {
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
	
	/*1st level chache wont work for HQL : bcz we are explicitly telling hibernate to fire SQL on database*/
	public void  getAllEmployees2() 
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
	}
	
	 public Employee getEmployeeById2(int empId) 
	  {  Employee emp1=null,emp2=null;
		  // if we want to select record on the basis of pk then direct method : get is available
		  try(Session session=sfactory.openSession();){ // session opened 
			Transaction tr=session.beginTransaction();
			System.out.println("******************");
		    emp1=session.get(Employee.class, empId);// select emp_id,emp_name, emp_salary, qualification from employee where emp_id=?
		    System.out.println("*********************");
		    // data will be saved in cache
		    emp2=session.get(Employee.class, empId); // data from cache
			tr.commit();
			System.out.println(emp1);
			System.out.println(emp2);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		  // session autoclosed, cache cleared
		 
		  return emp1;
	  }
	 public Employee getEmployeeById3(int empId) 
	  {  Employee emp1=null,emp2=null;
		  // if we want to select record on the basis of pk then direct method : get is available
		  try(Session session=sfactory.openSession();){ // session opened 
			Transaction tr=session.beginTransaction();
			System.out.println("******************");
		    emp1=session.get(Employee.class, empId);// select emp_id,emp_name, emp_salary, qualification from employee where emp_id=?
		    System.out.println("*********************");
		    // data will be saved in cache
		    emp2=session.get(Employee.class, empId); // data from cache
		    emp2=session.get(Employee.class, empId);
		    emp2=session.get(Employee.class, empId);
		    emp2=session.get(Employee.class, empId);
		    emp2=session.get(Employee.class, empId);
			tr.commit();
			System.out.println(emp1);
			System.out.println(emp2);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		  // session autoclosed
		 
		  return emp1;
	  }
} // method ended
	  
	  
	  
	  
	 
	
	
	
	

