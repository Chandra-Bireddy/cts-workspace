package com.cts.pb.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Phonebook implements Serializable {
	
	private String phoneNumber;
	private String name;
	
	public Phonebook() {
		super();
	}
	
	public Phonebook(String phoneNumber, String name) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Phonebook [phoneNumber=" + phoneNumber + ", name=" + name + "]";
	}
	
	
}
