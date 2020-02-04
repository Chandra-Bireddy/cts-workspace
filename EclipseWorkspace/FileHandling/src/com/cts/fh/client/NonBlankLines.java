package com.cts.fh.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NonBlankLines {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter filename");
			String fileName = sc.nextLine();
			@SuppressWarnings("resource")
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.equals("")) {
					if(!line.equals("\n"))
						System.out.println(line);
				}
			}
			
		}catch(FileNotFoundException excep) {
				System.out.println("No such file found");
		}catch(IOException excep) {
				System.out.println("Could not read file");
		}

	}

}
