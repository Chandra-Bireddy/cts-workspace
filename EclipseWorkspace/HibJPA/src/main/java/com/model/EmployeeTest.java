package com.model;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cts");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee e = new Employee();
		System.out.println("Enter Name:");
		String n=sc.nextLine();
		e.setEname(n);
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println("Inserted");
	}

}
