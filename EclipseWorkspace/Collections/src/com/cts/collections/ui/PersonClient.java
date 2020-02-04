package com.cts.collections.ui;

import java.util.Set;
import java.util.TreeSet;

import com.cts.collections.model.Person;

public class PersonClient {
	public static void main(String []args) {
		Set<Person> persons = new TreeSet<>();
		persons.add(new Person("Dipesh", 23));
		persons.add(new Person("ABC", 49));
		persons.add(new Person("XYZ",33));
		for(Person person: persons) {
			System.out.println(person);
		}
		System.out.println("------------------------------------------");
	}
}
