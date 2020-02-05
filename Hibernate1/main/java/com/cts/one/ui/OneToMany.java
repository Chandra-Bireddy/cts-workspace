package com.cts.one.ui;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cts.model1.Course;
import com.cts.model1.Trainee;
import com.cts.util.JPAUtil;
public class OneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course mca=new Course(101,"MCA",new TreeSet<Trainee>());
		Course mba=new Course(102,"MBA",new TreeSet<Trainee>());
		
		mca.getTrainees().add(new Trainee(201,"Chandra",mca));
		mca.getTrainees().add(new Trainee(202,"Anusha",mca));
		mca.getTrainees().add(new Trainee(203,"Aravind",mca));
		
		mba.getTrainees().add(new Trainee(204,"Srinu",mba));
		mba.getTrainees().add(new Trainee(205,"Seetha",mba));
		mba.getTrainees().add(new Trainee(206,"harsha",mba));
		EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(mca);
		em.persist(mba);
		t.commit();
	}
}

