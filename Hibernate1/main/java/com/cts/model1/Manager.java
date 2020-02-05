package com.cts.model1;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name="mgrs_only6")
public class Manager extends Employee {
	@Column(name="allowances")
	private double allowances;

	

	public Manager() {
		super();
	}
	public Manager(long eid, String ename, double basic,double allowances) {
		super(eid,ename,basic);
		this.allowances = allowances;
	}
	

	
	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}
	

}


