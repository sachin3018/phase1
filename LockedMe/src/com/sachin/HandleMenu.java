package com.sachin;

import java.util.List;
import java.util.Scanner;

public class HandleMenu {

	public static void handleFirstMenu() {
		boolean working = true;
		Scanner scan = new Scanner(System.in);
		
		do {
			try {
				Options.optionsOne();
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					FileStorage.retriveAllFile("main");
					break;
				case 2 : 
					HandleMenu.handleSecondMenu();
					break;
				case 0 : 
					System.out.println("ThankYou !! Comeback Soon ");
					working = false;
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please input valide option from menu");
					break;
				}
			}catch(Exception exception) {
				System.out.println(exception.getClass());
				handleFirstMenu();
			}
		}while(working);
	}
	
	public static void handleSecondMenu() {
		boolean working = true;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				Options.optionTwo();
				FileStorage.createMainFolder("main");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter File Name to add main folder: ");
					String fileName = scan.next();
					FileStorage.addFile(fileName);
					break;
				
				case 2 : 
					System.out.println("Enter the filename want to delete : ");
					String fileNameDelete = scan.next();
					List<String> filesDelete = FileStorage.findPath(fileNameDelete, "main");
					
					if(filesDelete.size() > 0) {
						System.out.println("Which file want to delete : ");
						int index = scan.nextInt();
						FileStorage.deleteSpecificFile(filesDelete.get(index-1));
					}
					
					break;
				
				case 3 : 
					System.out.println("Enter file name want to search : ");
					String fileNameSearch = scan.next();
					FileStorage.findPath(fileNameSearch, "main");
					break;
					
				case 4 : 
					HandleMenu.handleFirstMenu();
					break;
				default:
					System.out.println("Please provide a valid input from above menu");
					break;
				}
			}catch(Exception exception) {
				System.out.println(exception.getMessage().getClass());
			}
		}while(working);
	}
}
