package com.cts.al.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cts.al.model.GymMembers;

public class GymMembersClient {

	public static void main(String[] args) {
		List<GymMembers> gm = new ArrayList<>();
		gm.add(new GymMembers("Alan",23,2500));
		gm.add(new GymMembers("Ashley",21,2500));
		gm.add(new GymMembers("Ben",27,2000));
		gm.add(new GymMembers("Bob",24,2000));
		gm.add(new GymMembers("David",21,3000));
		gm.add(new GymMembers("Jack",22,3000));
		Collections.reverse(gm);
		
		for(GymMembers data: gm)
			System.out.println(data);
		
	}
	
//	private static void printList(ArrayList<String> names) {
//		// TODO Auto-generated method stub
//		for(String name: names) {
//			System.out.println(name);
//		}
//	}
}
