package com.w;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//public class Engineer implements DisposableBean, InitializingBean {
public class Engineer{
	
	List<Address> addresses;
	
	
	
	
//	Address address;
//	
//	Address address2;
//
//	public Address getAddress2() {
//		return address2;
//	}
//	
	


//	public Engineer(Address address, Address address2) {
//		this.address = address;
//		this.address2 = address2;
//	}
	
	
//	public void setAddress2(Address address2) {
//		this.address2 = address2;
//	}




//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//	
	
	
	
	
	public List<Address> getAddresses() {
		return addresses;
	}




	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}




	void work() {
		
		System.out.println("Engineer address details: ");
		
		for(Address add: addresses) {
			System.out.println(add.getLocation());
			System.out.println(add.getPinCode());
			System.out.println();
		}
		
		
		
		
//		System.out.println("Engineer Address details:" + this.getAddress().getLocation()
//		+ ", Pincode : " + this.getAddress().getPinCode());
//		System.out.println("Second Address details: "  
//		+ this.getAddress2().getLocation()
//		+ this.getAddress2().getPinCode()
//				);
		
//		"""
//		
//		lkkljekd
//		wkjekjwekjhwehrwkherkw
//		wjhejhwhqhegjqe
//		
//		"""
		
		
		
	}




	
	public void initBean(){
		System.out.println("Engineer bean just initialized");
		
	}



	public void beforeBeanDelete() {
		System.out.println("Bean about to go dead...");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
//	String uName;
//	int regId;
	
	
	
	
	
	
//	public Engineer(String uName, int regId) {
//		this.uName = uName;
//		this.regId = regId;
//	}
//
//
//	void work() {
//		System.out.println("Engineer details: \n Name: " + this.getuName()
//		+ ", ID : " + this.getRegId());
//	}
//
//
//	public String getuName() {
//		return uName;
//	}


//	public void setuName(String uName) {
//		this.uName = uName;
////		System.out.println("Setter injection done for User Name");
//	}


//	public int getRegId() {
//		return regId;
//	}


//	public void setRegId(int regId) {
//		this.regId = regId;
////		System.out.println("Setter injection done for User Reg ID");
//	}
}
