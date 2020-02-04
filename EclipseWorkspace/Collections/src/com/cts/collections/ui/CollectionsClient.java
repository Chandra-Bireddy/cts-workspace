package com.cts.collections.ui;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsClient {
	public static void main(String []args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("James Gosling");
		names.add("Alan Cooper");
		names.add("Bjarne Stroutroup");
		Collections.sort(names);
		printList(names);
		System.out.println("--------------------------------");
		int pos = Collections.binarySearch(names,"Alan Cooper");
		System.out.printf("Alan Cooper found at :%d\n",pos);
		System.out.printf("Maximum is: %s\n",Collections.max(names));
		System.out.println("---------------------------------");
		Collections.reverse(names);
		printList(names);
		System.out.println("---------------------------------");
	
	}

	private static void printList(ArrayList<String> names) {
		// TODO Auto-generated method stub
		for(String name: names) {
			System.out.println(name);
		}
	}
}
