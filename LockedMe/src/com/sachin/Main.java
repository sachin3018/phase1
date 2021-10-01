package com.sachin;

public class Main {

	public static void main(String args[]) {
		
		FileStorage.createMainFolder("main");
		Options.welcomeMesage("LockedMe", "Sachin Singh");
		HandleMenu.handleFirstMenu();
		
	}
}
