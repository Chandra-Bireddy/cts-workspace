package com.cts.Emart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Products {
	@Id
	@Column(name="Product_id")
		private int Product_id;
	@Column(name="Product_name")
		private String Product_name;
	@Column(name="Price")
		private double Price;
	@Column(name="Description")
		private String Description;
	@Column(name="Subcategory_id")
		private int Subcategory_id;
		public Products() 
		{
			
		}
		public Products(int product_id, String product_name, double price, String description, int subcategory_id) {
			super();
			this.Product_id = product_id;
			this.Product_name = product_name;
			this.Price = price;
			this.Description = description;
			this.Subcategory_id = subcategory_id;
		}
		public int getProduct_id() {
			return Product_id;
		}
		public void setProduct_id(int product_id) {
			Product_id = product_id;
		}
		public String getProduct_name() {
			return Product_name;
		}
		public void setProduct_name(String product_name) {
			Product_name = product_name;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(int price) {
			Price = price;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public int getSubcategory_id() {
			return Subcategory_id;
		}
		public void setSubcategory_id(int subcategory_id) {
			Subcategory_id = subcategory_id;
		}
		
}
