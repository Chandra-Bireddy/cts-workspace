package com.cts.oopp.model;

public class Employee extends Person{
	private int salary;
	public Employee() {		// calling superclass constructor
		super();
	}
	public Employee(String name, int age, int salary) {
		super(name, age); 		//calling superclass parameter constructor
		this.salary= salary;
	}
	public void setSalary(int salary) {
		this.salary= salary;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return super.toString()+" Salary: " +salary;
	}
}
