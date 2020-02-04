package com.w;

public class Automobile {
	String name;
	int regNo;
	
	void plies() {
		System.out.println("Automobile details:\nName:"+getName()+"\nRegistered No.:"+getRegNo());
	}
	
	public Automobile(String name, int regNo) {
		super();
		this.name = name;
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	
	
}
