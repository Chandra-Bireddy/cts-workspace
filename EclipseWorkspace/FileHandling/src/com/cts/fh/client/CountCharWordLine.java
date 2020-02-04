package com.cts.fh.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountCharWordLine {

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
			int chars = 0;
			int lines = 0;
			int words = 0;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				if(!line.equals("")) {
					chars+=line.length();
					
					// \\s+ is the space delimiter in java
					String[] wordList = line.split(" "); 
	                words += wordList.length;
	                
	             // [!?.:]+ is the sentence delimiter in java 
	                String[] sentenceList = line.split("\n"); 
	                  
	                lines += sentenceList.length;
				}
			}
			System.out.println("Number of characters: "+chars);
			System.out.println("Number of words: "+words);
			System.out.println("Number of lines: "+lines);
			
		}catch(FileNotFoundException excep) {
				System.out.println("No such file found");
		}catch(IOException excep) {
				System.out.println("Could not read file");
		}

	}

}
