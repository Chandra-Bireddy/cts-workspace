package com.cts.Emart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SubCategory")
public class SubCategory {
	@Id
	@Column(name="Subcategory_id")
        private int Subcategory_id;
	@Column(name="Subcategory_name")
        private int Subcategory_name;
	@Column(name="Category_id")
        private int Category_id;
        public SubCategory() 
        {
        	
        }
		public SubCategory(int subcategory_id, int subcategory_name, int category_id) {
			super();
			this.Subcategory_id = subcategory_id;
			this.Subcategory_name = subcategory_name;
			this.Category_id = category_id;
		}
		public int getSubcategory_id() {
			return Subcategory_id;
		}
		public void setSubcategory_id(int subcategory_id) {
			Subcategory_id = subcategory_id;
		}
		public int getSubcategory_name() {
			return Subcategory_name;
		}
		public void setSubcategory_name(int subcategory_name) {
			Subcategory_name = subcategory_name;
		}
		public int getCategory_id() {
			return Category_id;
		}
		public void setCategory_id(int category_id) {
			Category_id = category_id;
		}


        
}
