package com.cts.collections.ui;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private LocalDate birthDate;
	private double salary;
	
	public Employee(int id, String name, LocalDate birthDate, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee other) {
		Integer firstId = this.getId();
		Integer otherId = other.getId();
		return firstId.compareTo(otherId);
	}

}
