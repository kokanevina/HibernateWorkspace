package com.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.ProjectionList;
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
	public void criteriaMeth3(){
		List mylist=null;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Employee.class);
		//cr.setProjection(Projections.max("empSalary"));
		//cr.setProjection(Projections.min("empSalary"));
		//cr.setProjection(Projections.sum("empSalary"));
		cr.setProjection(Projections.avg("empSalary"));
		mylist=cr.list();
		tr.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mylist);
	}
	public void criteriaMeth4(){
		List mylist=null;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.max("empSalary"));
		projectionList.add(Projections.groupProperty("qualification"));
		criteria.setProjection(projectionList);
		 mylist = criteria.list();
		tr.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Iterator it = mylist.iterator();
		while(it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			for (int i = 0; i < obj.length; i++) {
				System.out.print(obj[i]+"  ");
			}
			System.out.println();
		}
	}
	
	public void criteriaMeth5(){
		List mylist=null;
		try(Session session=sfactory.openSession();){
		Transaction tr=session.beginTransaction();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.between("empSalary", 35000.0, 50000.0));
	//LogicalExpression expression=  Restrictions.and(Restrictions.ge("empSalary", 35000.0), Restrictions.le("empSalary", 50000.0));
		//cr.add(expression);
		mylist = cr.list();
		tr.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		mylist.forEach(System.out::println);
	}
	// crate new method for	
	//select * from employee where qualification = 'ME' and salary > 40000

}
