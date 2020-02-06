package com.cts.Emart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Seller")
public class Seller {
	@Id
	@Column(name="Seller_id")
     private int Seller_id;
	@Column(name="Seller_name")
     private String Seller_name;
	@Column(name="Password")
     private String Password;
	@Column(name="Mobile_no")
     private int Mobile_no;
	@Column(name="Brand_name")
     private String Brand_name;
	@Column(name="Product_id")
     private int Product_id;
     public Seller() 
     {
    	 
     }
	public Seller(int seller_id, String seller_name, String password, int mobile_no, String brand_name,
			int product_id) {
		super();
		this.Seller_id = seller_id;
		this.Seller_name = seller_name;
		this.Password = password;
		this.Mobile_no = mobile_no;
		this.Brand_name = brand_name;
		this.Product_id = product_id;
	}
	public int getSeller_id() {
		return Seller_id;
	}
	public void setSeller_id(int seller_id) {
		Seller_id = seller_id;
	}
	public String getSeller_name() {
		return Seller_name;
	}
	public void setSeller_name(String seller_name) {
		Seller_name = seller_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(int mobile_no) {
		Mobile_no = mobile_no;
	}
	public String getBrand_name() {
		return Brand_name;
	}
	public void setBrand_name(String brand_name) {
		Brand_name = brand_name;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
     
}
