package com.cts.gm.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Represents a book in a library or book store.
 */
@SuppressWarnings("serial")
public class GymMembers implements Serializable /* implements Comparable<Book> */ {

	private String mId;
	private String name;
	private LocalDate joiningDate;
	private double fees;

	public GymMembers() {
		/* default constructor */
	}

	public GymMembers(String mId, String name, LocalDate joiningDate, double fees) {
		super();
		this.mId = mId;
		this.name = name;
		this.joiningDate = joiningDate;
		this.fees = fees;
	}

	public String getMId() {
		return mId;
	}

	public void setMId(String mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Member Id : ");
		output.append(mId);
		output.append("\tName : ");
		output.append(name);
		output.append("\tJoining Date :");
		output.append(joiningDate);
		output.append("\tFees : ");
		output.append(fees);
		return output.toString();
	}

	
	/*
	@Override
	public int compareTo(Book book) {
		String firstBCode = this.bcode;
		String secondBCode = book.bcode;
		return firstBCode.compareTo(secondBCode);
	}
		
	@Override
	public int hashCode() {
		int hashCode =0;
		char[] chars = bcode.toCharArray();
		for(int i=1;i<=chars.length;i++){
			hashCode += ((int)chars[i-1])*i;
		}
		
		return hashCode;
	}
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj instanceof Book) {
			Book book = (Book)obj;
			String firstBCode = this.bcode;
			String secondBCode = book.bcode;
			flag= firstBCode.equals(secondBCode);
		}
		
		return flag;		
	}
*/
}