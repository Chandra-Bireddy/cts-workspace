package com.cts.gm.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.cts.gm.exception.GymMembersException;
import com.cts.gm.model.GymMembers;
import com.cts.gm.model.GymMembersMenu;
import com.cts.gm.service.GymMembersServiceImpl;
import com.cts.gm.service.IGymMembersService;

public class GymMembersUI {

	private static IGymMembersService memberService;
	private static Scanner scan;
	private static DateTimeFormatter dtFormater;

	public static void main(String[] args) {

		try {
			memberService = new GymMembersServiceImpl();
		} catch (GymMembersException e) {
			e.printStackTrace();
		}


		scan = new Scanner(System.in);
		dtFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		GymMembersMenu menu = null;

		while (menu != GymMembersMenu.QUIT) {

			System.out.println("Choice\tMenu Item");
			System.out.println("===========================");
			for (GymMembersMenu m : GymMembersMenu.values()) {
				System.out.println(m.ordinal() + "\t" + m.name());
			}
			System.out.print("Choice: ");
			int choice = -1;
			if (scan.hasNextInt())
				choice = scan.nextInt();
			else {
				scan.next();
				System.out.println("Pleae choose a choice displayed");
				continue;
			}

			if (choice < 0 || choice >= GymMembersMenu.values().length) {
				System.out.println("Invalid Choice");
			} else {
				menu = GymMembersMenu.values()[choice];
				switch (menu) {
				case ADD:
					doAdd();
					break;
				case LIST:
					doList();
					break;
				case SEARCH:
					doSearch();
					break;
				case REMOVE:
					doRemove();
					break;
				case QUIT:
					System.out.println("ThanQ Come Again!");
					break;
				}
			}

		}

		scan.close();
		try {
			memberService.persist();
		} catch (GymMembersException e) {
			e.printStackTrace();
		}

	}

	private static void doAdd() {
		try {
			GymMembers member = new GymMembers();
			System.out.print("MemberId: ");
			member.setMId(scan.next());
			System.out.print("Name: ");
			member.setName(scan.next());
			System.out.print("JoiningDate(dd-MM-yyyy): ");
			String joiDtStr = scan.next();

			try {
				member.setJoiningDate(LocalDate.parse(joiDtStr, dtFormater));
			} catch (DateTimeException exp) {
				throw new GymMembersException(
						"Date must be in the format day(dd)-month(MM)-year(yyyy)");
			}
			System.out.print("Fees: ");
			if (scan.hasNextDouble())
				member.setFees(scan.nextDouble());
			else {
				scan.next();
				throw new GymMembersException("Fees is a number");
			}

			String mId = memberService.add(member);
			System.out.println("Member is Added with Id: " + mId);
		} catch (GymMembersException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doList() {
		List<GymMembers> members;
		try {
			members = memberService.getAll();
			if (members.size() == 0) {
				System.out.println("No Members To display");
			} else {
				for (GymMembers b : members)
					System.out.println(b);
			}
		} catch (GymMembersException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doSearch() {
		System.out.print("MId: ");
		String mId = scan.next();

		try {
			GymMembers member = memberService.get(mId);
			if (member != null) {
				System.out.println(member);
			} else {
				System.out.println("No Such Members");
			}
		} catch (GymMembersException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doRemove() {
		System.out.print("MId: ");
		String mId = scan.next();
		try {
			boolean isDone = memberService.delete(mId);
			if (isDone) {
				System.out.println("Member is Deleted");
			} else {
				System.out.println("No Such Members");
			}
		} catch (GymMembersException exp) {
			System.out.println(exp.getMessage());
		}
	}
}