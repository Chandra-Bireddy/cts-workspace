package com.cts.one.ui;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cts.model1.BankAccount;
import com.cts.model1.Customer;
import com.cts.util.JPAUtil;


public class OneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ba=new BankAccount();
		Customer cs=new Customer("9849075668","Suda",ba);
		ba.setAccno("SB00015405");
		ba.setCustomer(cs);
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(cs);
		t.commit();
		JPAUtil.shutdown();
		

	}

}
	