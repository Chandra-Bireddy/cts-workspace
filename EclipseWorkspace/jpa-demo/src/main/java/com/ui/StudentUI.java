package com.ui;

import java.util.Date;

import javax.persistence.EntityManager;

import com.model.Student;
import com.model.StudentIdentity;
import com.util.JPAUtil;

public class StudentUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s = new Student(new StudentIdentity(1,'A',7),"Dipesh","Harijan", new Date(2001,5,2));
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		System.out.println("Student Saved");
		JPAUtil.shutdown();
	}

}
