package com.cts.oopp.ui;

import com.cts.oopp.model.Employee;
import com.cts.oopp.model.Person;

public class InheritanceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person= new Person();
		person.setName("Srinivas");
		person.setAge(53);
		System.out.println(person);
		Employee employee= new Employee();
		employee.setName("Meghna");
		employee.setAge(21);
		employee.setSalary(350000);
		System.out.println(employee);
	}

}
