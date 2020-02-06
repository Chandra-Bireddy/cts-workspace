package com.cts.Emart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	  @Id
	  @Column(name="Category_id")
      private int Category_id;
	  @Column(name="Category_Name")
      private String Category_Name;
	  @Column(name="GST_percent")
      private double GST_percent;
      public Category() 
      {
    	  
      }
	public Category(int category_id, String category_Name, double gST_percent) {
		super();
		Category_id = category_id;
		Category_Name = category_Name;
		GST_percent = gST_percent;
	}
	public int getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}
	public String getCategory_Name() {
		return Category_Name;
	}
	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}
	public double getGST_percent() {
		return GST_percent;
	}
	public void setGST_percent(double gST_percent) {
		GST_percent = gST_percent;
	}
	

      
}
