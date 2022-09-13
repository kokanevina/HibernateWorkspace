package com.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
		if(em.getEmpId()==(int)id)
			b=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	/*
	 * public boolean updateEmployee(Employee em) { boolean b=false; String
	 * sql="update employee set emp_name=?,emp_salary=?, qualification=? where emp_id=?"
	 * ; try (Connection connection=MyConnection.connect()){ PreparedStatement
	 * pstatement=connection.prepareStatement(sql); pstatement.setInt(4,
	 * em.getEmpId()); pstatement.setString(1, em.getEmpName());
	 * pstatement.setDouble(2, em.getEmpSalary()); pstatement.setString(3,
	 * em.getQualification()); System.out.println(pstatement); int
	 * no=pstatement.executeUpdate();
	 * System.out.println("Number of rows affected: "+no); if(no>0) b=true; } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException e) {
	 * e.printStackTrace(); } System.out.println("Connection Autoclosed"); return b;
	 * 
	 * } public boolean deleteEmployee(int empId) { boolean b=false; String
	 * sql="delete from employee where emp_id=?"; try (Connection
	 * connection=MyConnection.connect()){ PreparedStatement
	 * pstatement=connection.prepareStatement(sql); pstatement.setInt(1, empId);
	 * System.out.println(pstatement); int no=pstatement.executeUpdate();
	 * System.out.println("Number of rows affected: "+no); if(no>0) b=true; } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException e) {
	 * e.printStackTrace(); } System.out.println("Connection Autoclosed"); return b;
	 * }
	 * 
	 * public Employee getEmployeeById(int empId) { Employee emp=null; String
	 * sql="select * from employee where emp_id=?"; try (Connection
	 * connection=MyConnection.connect()){ PreparedStatement
	 * pstatement=connection.prepareStatement(sql); pstatement.setInt(1, empId);
	 * System.out.println(pstatement); ResultSet rset= pstatement.executeQuery();
	 * while(rset.next()) { int id=rset.getInt("emp_id"); String
	 * name=rset.getString("emp_name"); double salary=rset.getDouble("emp_salary");
	 * String qual=rset.getString("qualification"); emp=new
	 * Employee(id,name,salary,qual); }
	 * 
	 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
	 * (SQLException e) { e.printStackTrace(); }
	 * System.out.println("Connection Autoclosed"); return emp; }
	 * */
	
	public List<Employee> getAllEmployees() 
	{ 
		List<Employee> empList=null;
		try(Session session=sfactory.openSession();){
			Transaction tr=session.beginTransaction();
			Query query=session.createQuery("from Employee"); // HQL Employee : pojo class name 
			empList= query.list();	
			tr.commit();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return empList;
	}
} // method ended
	  
	  
	  
	  
	 
	
	
	
	

