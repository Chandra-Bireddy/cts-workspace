package com.cts.Emart.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Order")
public class Order {
	@Id
	@Column(name="Order_id")
		private int Order_id;
	@Column(name="Order_Date")
		private LocalDate Order_Date;
	@Column(name="Total_Amount")
		private double Total_Amount;
	@Column(name="Discount_id")
		private int Discount_id;
	@Column(name="Discount_value")
		private int Discount_value;
		public Order() 
		{
			
		}
		public Order(int order_id, LocalDate order_Date, double total_Amount, int discount_id, int discount_value) {
			super();
			Order_id = order_id;
			Order_Date = order_Date;
			Total_Amount = total_Amount;
			Discount_id = discount_id;
			Discount_value = discount_value;
		}
		public int getOrder_id() {
			return Order_id;
		}
		public void setOrder_id(int order_id) {
			Order_id = order_id;
		}
		public LocalDate getOrder_Date() {
			return Order_Date;
		}
		public void setOrder_Date(LocalDate order_Date) {
			Order_Date = order_Date;
		}
		public double getTotal_Amount() {
			return Total_Amount;
		}
		public void setTotal_Amount(double total_Amount) {
			Total_Amount = total_Amount;
		}
		public int getDiscount_id() {
			return Discount_id;
		}
		public void setDiscount_id(int discount_id) {
			Discount_id = discount_id;
		}
		public int getDiscount_value() {
			return Discount_value;
		}
		public void setDiscount_value(int discount_value) {
			Discount_value = discount_value;
		}
		
}
