package com.cts.collections.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListClient {
	public static void main(String []args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<String> names = new ArrayList<>();
		String name = null;
		while(true) {
			System.out.println("Enter name:");
			name = sc.nextLine();
			if(name.equals("end")) {
				break;
			}
			names.add(name);
		}
		for(String data: names) {
			System.out.println(data);
		}
	}
}
