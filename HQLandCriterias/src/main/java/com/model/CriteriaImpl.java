package com.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.db.MyConnection;
import com.pojo.Employee;

public class CriteriaImpl {
	SessionFactory sfactory;
	public CriteriaImpl() {
			sfactory=MyConnection.connect();
			System.out.println("Connection Done.......");
	}
	
	public void criteriaMeth1(){
		List<Employee> empList=null;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Employee.class);
	//	cr.add(Restrictions.gt("empSalary", 35000.0));
		//cr.add(Restrictions.ge("empSalary", 35000.0));
		//cr.add(Restrictions.lt("empSalary", 35000.0));
		//cr.add(Restrictions.le("empSalary", 35000.0));
		//cr.add(Restrictions.ne("empSalary", 35000.0));
		cr.add(Restrictions.eq("empSalary", 35000.0));
		empList= cr.list();
		tr.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		empList.forEach(System.out::println);
	}
	
	public void criteriaMeth2(){
		List mylist=null;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Employee.class);
		//cr.add(Restrictions.eq("empSalary", 35000.0));
		cr.add(Restrictions.eq("qualification", "ME"));
		cr.setProjection(Projections.count("empId"));
		mylist=cr.list();
		tr.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mylist);
	}
	
}
