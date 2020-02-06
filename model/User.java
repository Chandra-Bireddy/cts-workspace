package com.cts.Emart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@Column(name="User_id")
      private int User_id;
	@Column(name="User_name")
      private String User_name;
	@Column(name="Password")
      private String Password;
	@Column(name="Email_id")
      private String Email_id;
	@Column(name="Mobile_no")
      private int Mobile_no;
      public User() 
      {
    	  
      }
	public User(int user_id, String user_name, String password, String email_id, int mobile_no) {
		super();
		User_id = user_id;
		User_name = user_name;
		Password = password;
		Email_id = email_id;
		Mobile_no = mobile_no;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public int getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(int mobile_no) {
		Mobile_no = mobile_no;
	}
      
}