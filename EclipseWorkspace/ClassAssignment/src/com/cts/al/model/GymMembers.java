package com.cts.al.model;

import java.util.Collections;

public class GymMembers {
	String name;
	int age;
	int fees;
	
	public GymMembers(String name, int age, int fees) {
		super();
		this.name = name;
		this.age = age;
		this.fees = fees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", age=" + age + ", fees=" + fees;
	}

//	public GymMembers sort(GymMembers g) {
//		Collections.sort();
//		
//	}
	
}
