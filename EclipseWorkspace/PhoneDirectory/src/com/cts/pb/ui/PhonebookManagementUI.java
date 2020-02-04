package com.cts.pb.ui;

import java.util.List;
import java.util.Scanner;

import com.cts.pb.exception.PhonebookException;
import com.cts.pb.model.Phonebook;
import com.cts.pb.model.PhonebookMenu;
import com.cts.pb.service.IPhonebookService;
import com.cts.pb.service.PhonebookServiceImpl;

public class PhonebookManagementUI {
	private static IPhonebookService pService;
	private static Scanner scan;
	public static void main(String[] args) {
		
		try {
			pService = new PhonebookServiceImpl();
		} catch(PhonebookException e) {
			e.printStackTrace();
		}
		
		scan= new Scanner(System.in);
		PhonebookMenu menu= null;
		while(menu!=PhonebookMenu.QUIT) {
			System.out.println("Choice\tMenu Item");
			System.out.println("==========================");
			for(PhonebookMenu m: PhonebookMenu.values()) {
				System.out.println(m.ordinal()+"\t"+m.name());
			}
			System.out.println("Choice");
			int choice = -1;
			if (scan.hasNextInt())
				choice = scan.nextInt();
			else {
				scan.next();
				System.out.println("Pleae choose a choice displayed");
				continue;
			}
			if (choice < 0 || choice >= PhonebookMenu.values().length) {
				System.out.println("Invalid Choice");
			} else {
				menu = PhonebookMenu.values()[choice];
				switch (menu) {
				case ADD:
					doAdd();
					break;
				case DELETE:
					doList();
					break;
				case SEARCH:
					doSearch();
					break;
				case DISPLAY:
					doRemove();
					break;
				case QUIT:
					System.out.println("ThanQ Come Again!");
					break;
				}
			}
		}scan.close();
	}

	private static void doAdd() {
		try{
			Phonebook pbook = new Phonebook();
			System.out.print("Number: ");
			pbook.setPhoneNumber(scan.next());
			System.out.print("Name: ");
			pbook.setName(scan.next());
		}
		catch(PhonebookException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void doList() {
		List<Phonebook> pbook;
		try {
			pbook = pService.getAll();
			if (pbook.size() == 0) {
				System.out.println("No Books To display");
			} else {
				for (Phonebook b : pbook)
					System.out.println(b);
			}
		} catch (PhonebookException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doSearch() {
		System.out.print("Number: ");
		String number = scan.next();

		try {
			Phonebook book = pService.get(number);
			if (book != null) {
				System.out.println(book);
			} else {
				System.out.println("No Such Book");
			}
		} catch (PhonebookException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doRemove() {
		System.out.print("BCode: ");
		String bcode = scan.next();
		try {
			boolean isDone = pService.delete(bcode);
			if (isDone) {
				System.out.println("Book is Deleted");
			} else {
				System.out.println("No Such Book");
			}
		} catch (PhonebookException exp) {
			System.out.println(exp.getMessage());
		}
	}
}