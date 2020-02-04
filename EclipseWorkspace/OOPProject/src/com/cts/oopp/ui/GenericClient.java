package com.cts.oopp.ui;

import com.cts.oopp.model.GenericClass;

public class GenericClient {

	public static void main(String[] args) {
		GenericClass<Integer> m = new GenericClass<Integer>();
		m.add(2);
		System.out.println(m.get());
		
		GenericClass<String> m2 = new GenericClass<>();  //type inference
		m2.add("98");
		System.out.println(m2.get());
	}

}
