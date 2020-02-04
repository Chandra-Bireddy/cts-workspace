package com.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.model.Employee;
import com.util.JPAUtil;

public class EmpUi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Employee e = new Employee();
		System.out.println("EmpId:");
		e.setEmpId(scan.nextInt());
		System.out.println("EName: ");
		e.setEmpName(scan.next());
		System.out.println("Basic:");
		e.setBasic(scan.nextDouble());
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		System.out.println("Emp Saved");
		JPAUtil.shutdown();
		scan.close();
	}

}
