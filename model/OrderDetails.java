package com.cts.Emart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetails")
public class OrderDetails {
@Id
@Column(name="Order_id")
     private int  Order_id;
@Column(name="Product_id")
     private int Product_id;
@Column(name="Quantity")
     private double Quantity;
@Column(name="Price")
     private double Price;
@Column(name="Total_Amount")
     private double Total_Amount;
     public OrderDetails() 
     {
    	 
     }
	public OrderDetails(int order_id, int product_id, double quantity, double price, double total_Amount) {
		super();
		Order_id = order_id;
		Product_id = product_id;
		Quantity = quantity;
		Price = price;
		Total_Amount = total_Amount;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(double total_Amount) {
		Total_Amount = total_Amount;
	}
}