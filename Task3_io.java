package com.Shalaka.Internship;

import java.util.*;
import java.io.*;

public class Task3_io {
	
	public static final String filename="note.txt";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running=true;
		
		while(running) {
			System.out.println("1. Add note");
			System.out.println("2. view note");
			System.out.println("3. Exit");
			System.out.println("Choose an option");

			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter your note");
				String note=sc.nextLine();
				addnote(note);
				break;
			case 2:
				viewnote();
				break;
			case 3:
				running=false;
				System.out.println("Exiting the note");
				break;
			default:
				System.out.println("Invalid choice! try Again");
			}

		}
		sc.close();
	}
	
	public static void addnote(String note) {
		try(FileWriter fw=new FileWriter(filename,true)){
			fw.write(note+ "\n");
			System.out.println("Note saved!");
		}catch(IOException e) {
			System.out.println("Error reading notes: " +e.getMessage());
		}
	}
	
	public static void viewnote() {
		try(BufferedReader br=new BufferedReader(new FileReader(filename))){
			String line;
			System.out.println("**Your notes**");
			while((line = br.readLine())!=null) {
				System.out.println("-"+line);
			}
		}catch(FileNotFoundException e) {
			System.out.println("No notes found! Pleaseadd some first");
		}catch(IOException e) {
			System.out.println("Error reading notes: " +e.getMessage());
		}
	}
}