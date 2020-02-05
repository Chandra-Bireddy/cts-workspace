package com.cts.one.ui;
import javax.persistence.EntityManager;

import com.cts.model1.Address;
import com.cts.model1.Faculty;
import com.cts.util.JPAUtil;


public class Composition {

	public static void main(String[] args) {
	Faculty f=new Faculty("Chandra",new Address("G123","BBr Apartments","Banglore,Karnataka"));
	
	EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
	em.getTransaction().begin();
	em.persist(f);
	em.getTransaction().commit();
//	em.flush();
	
	System.out.println("Faculty saved");
	JPAUtil.shutdown();
	}

}
