package com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.db.MyConnection;
import com.pojo.Employee;

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
	
	public void executeHQL() {
		// table : pojo class
		// columns: pojo variables
		//Q.  select employees having salary >34000
		String hql="from Employee where empSalary>34000";
		String hql1="from Employee where qualification='BE'";
		List<Employee> empList=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			TypedQuery<Employee> query=session.createQuery(hql1, Employee.class); 
			empList= query.getResultList();
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println(empList);
	}
	
	public void executeHQL2() {
		String hql="select empId from Employee where empSalary<34000";
		List<Integer> idList=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			TypedQuery<Integer> query=session.createQuery(hql, Integer.class); 
			idList= query.getResultList();
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println(idList);
	}
	public void executeHQL3() {
		String hql="select empId,empName from Employee where empSalary<34000";
		List<Employee> empList=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			TypedQuery<Employee> query=session.createQuery(hql, Employee.class); 
			empList= query.getResultList();
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println(empList);
	}
} // method ended
	  
	  
	  
	  
	 
	
	
	
	

