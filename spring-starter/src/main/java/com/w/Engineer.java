package com.w;

public class Engineer {

	
	String uName;
	int regId;
	
	
	
	
	public Engineer(String uName, int regId) {
		this.uName = uName;
		this.regId = regId;
	}


	void work() {
		System.out.println("Engineer details: \n Name: " + this.getuName()
		+ ", ID : " + this.getRegId());
	}


	public String getuName() {
		return uName;
	}


//	public void setuName(String uName) {
//		this.uName = uName;
////		System.out.println("Setter injection done for User Name");
//	}


	public int getRegId() {
		return regId;
	}


//	public void setRegId(int regId) {
//		this.regId = regId;
////		System.out.println("Setter injection done for User Reg ID");
//	}
}
