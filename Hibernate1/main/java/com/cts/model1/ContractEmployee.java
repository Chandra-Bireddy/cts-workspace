package com.cts.model1;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("cemp")
@Table(name="cmp2")
public class ContractEmployee extends Employee {
	@Column(name="cdur")
	private int duration;

	public ContractEmployee(long eid, String ename, double basic,int duration) {
		super(eid,ename,basic);
		this.duration = duration;
		
	}

	public ContractEmployee() {
		super();
	}
}