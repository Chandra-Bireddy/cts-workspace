package com.cts.fh.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindGivenWord {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try{
			System.out.println("Enter the file name");
			Scanner sc = new Scanner(System.in);
			String fileName = sc.nextLine();
			System.out.println("Enter a word to find its occurences");
			String word = sc.next();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String []match = null;
			String line;
			int count=0;
			while((line = br.readLine()) != null) {
				 match = line.split(" ");
				 for(String s: match) {
					 if(s.equals(word)) {
						 System.out.println(line);
						 count++;
						 break;
					 }
				 }
			}
			if(count==0)
				System.out.println("Word not present");
		}
		catch(FileNotFoundException excep) {
			System.out.println("No such file found");
	}catch(IOException excep) {
			System.out.println("Could not read file");
	}
	}

}
