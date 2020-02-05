package com.cts.one.ui;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cts.model1.Employee;
import com.cts.util.JPAUtil;

public class JPQLExample {

	public static void main(String[] args) {
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		Employee emp=em.find(Employee.class,10 );
		if(emp!=null) {
			System.out.println(emp);
		}
		String queryString ="SELECT e FROM Employee e";
		Query qry=em.createQuery(queryString);
		
		display(qry.getResultList());
		
		display(em.createQuery("SELECT e FROM Employee e WHERE e.basic>500").getResultList());
		
		List<String> names=em.createQuery("SELECT e.empName FROM Employee e").getResultList();
		
		for(String n:names) {
			System.out.println(n);
		}
		em.close();
		JPAUtil.shutdown();

	}
	static void display(List<Employee>data) {
		System.out.println("----------------------");
		for(Employee e:data) {
			System.out.println(e);
		}
	}

}