package com.cts.Emart.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@Column(name="Payment_id")
	   private int Payment_id;
	@Column(name="Order_id")
	   private int Order_id;
	@Column(name="Payment_Date")
	   private LocalDate Payment_Date;
	@Column(name="Payment_price")
	   private double Payment_price;
	@Column(name="Payment_mode")
	   private String Payment_mode;
	   public Payment() 
	   {
		   
	   }
	public Payment(int payment_id, int order_id, LocalDate payment_Date, double payment_price, String payment_mode) {
		super();
		this.Payment_id = payment_id;
		this.Order_id = order_id;
		this.Payment_Date = payment_Date;
		this.Payment_price = payment_price;
		this.Payment_mode = payment_mode;
	}
	public int getPayment_id() {
		return Payment_id;
	}
	public void setPayment_id(int payment_id) {
		Payment_id = payment_id;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public LocalDate getPayment_Date() {
		return Payment_Date;
	}
	public void setPayment_Date(LocalDate payment_Date) {
		Payment_Date = payment_Date;
	}
	public double getPayment_price() {
		return Payment_price;
	}
	public void setPayment_price(int payment_price) {
		Payment_price = payment_price;
	}
	public String getPayment_mode() {
		return Payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		Payment_mode = payment_mode;
	}
	   
}
