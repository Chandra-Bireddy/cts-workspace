package com.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentIdentity implements Serializable {
	
	private static final long serialVersionUID=1L;
	private int rollNumber;
	private char section;
	private int clazz;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public int getClazz() {
		return clazz;
	}
	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public StudentIdentity(int rollNumber, char section, int clazz) {
		super();
		this.rollNumber = rollNumber;
		this.section = section;
		this.clazz = clazz;
	}
	public StudentIdentity() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clazz;
		result = prime * result + rollNumber;
		result = prime * result + section;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentIdentity other = (StudentIdentity) obj;
		if (clazz != other.clazz)
			return false;
		if (rollNumber != other.rollNumber)
			return false;
		if (section != other.section)
			return false;
		return true;
	}
}
