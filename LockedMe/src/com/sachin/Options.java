package com.sachin;

public class Options {
	
	public static void welcomeMesage(String projectName, String developerName) {
		String message = String.format(
						"---------------------------------------------------------------------\n"+
						"  Welcome to %s.com \n"+	
						"  Developer Name %s \n"+
						"---------------------------------------------------------------------\n",
						projectName,
						developerName
				);
		String options = String.format(
						"---------------------------------------------------------------------\n"+
						" Functionality\n"+ "\n"+
						"# retrive all files from \"main\" folder\n"+
						"# add,delete,search on \"main\" folder\n"+
						"---------------------------------------------------------------------\n"
				);
		
		System.out.println(message);
		System.out.println(options);
	}
	
	
	public static void optionsOne() {
		String label = String.format(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
						"1 To retrive all files from \"main\" folder\n"+
						"2 To add,delete,search on \"main\" folder\n"+
						"0 Exit application\n"+
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				);
		System.out.println(label);
	}
	
	public static void optionTwo() {
		String label = String.format(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
						"1) Add a file to \"main\" folder\n" + 
						"2) Delete a file from \"main\" folder\n"+
						"3) Search for a file from \"main\" folder\n" + 
						"4) Show Previous Menu\n" + 
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				);
		System.out.println(label);
	}
}
