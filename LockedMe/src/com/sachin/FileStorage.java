package com.sachin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileStorage {
	
	//creating main folder if not exist
	public static void createMainFolder(String folderName) {
		File file = new File(folderName);
		
		if(!file.exists()) {
			file.mkdir();
		}
	}
	
	
	//all file in ascending order sorting
	public static void retriveAllFile(String path) {
		
		List<String> fileList = FileStorage.getAllFile("main", 0, new ArrayList<String>());
		
		System.out.println("List in Ascending order");
		Collections.sort(fileList);
		fileList.stream().forEach(System.out::println);
		
	}
	
	
	//get files inside of every function
	public static List<String> getAllFile(String path,int seprator,List<String> result){
		File repository = new File(path);
		File[] file = repository.listFiles();
		List<File> filelist = Arrays.asList(file);
		
		
		Collections.sort(filelist);
		
		if(file != null && file.length > 0) {
			for(File f : filelist) {
				System.out.println("-".repeat(seprator*3));
				if(f.isDirectory()) {
					System.out.println("`-- " + f.getName());
					result.add(f.getName());
					getAllFile(f.getAbsolutePath(), seprator+1, result);
				}else {
					System.out.println("|-- " + f.getName());
					result.add(f.getName());
				}
			}
		}else {
			System.out.println("--- Empty Directory ---");
		}
		return result;
	}
	
	//add file to the proposed directory
	public static void addFile(String filename) {
		
		Path path = Paths.get("./main/"+filename);
		try {
			
			Files.createDirectories(path.getParent());
			Files.createFile(path);
			System.out.println(filename+" Created Successfully");
			
		}catch(IOException ioException) {
			System.out.println("Failed to create File...");
		}
	}
	
	//finding the path of some specific fileName
	public static List<String> findPath(String fileName,String path){
		List<String> fileListName = new ArrayList<String>();
		FileStorage.searchByFileName(path, fileName, fileListName);
		if(fileListName.isEmpty()) {
			System.out.println("File Not Fount");
		}else {
			System.out.println("\nYey!! Found it\nLocation(s) Displayed below : ");
			int index = 1;
			for(String location : fileListName) {
				System.out.println(index + " : " + location);
				index += 1;
			}
		}
		return fileListName;
	}
	
	//find all the file location whose initials matches with the given
	public static void searchByFileName(String path,String fileName,List<String> fileList) {
		File repository = new File(path);
		File[] files = repository.listFiles();
		List<File> grabedFileList = Arrays.asList(files);
		
		if(files != null && files.length > 0) {
			for(File file : grabedFileList) {
				if(file.getName().startsWith(fileName)) {
					fileList.add(file.getAbsolutePath());
				}
				
				//we need to search in all directories because same name file can exist in more then folder.
				if(file.isDirectory()) {
					searchByFileName(file.getAbsolutePath(), fileName, fileList);
				}
			}
		}
		
		
	}
	
	
	//delete the specific file with a provided location or path
	public static void deleteSpecificFile(String path) {
			File currFile = new File(path);
			if(currFile.delete()) {
				System.out.println(currFile.getName() + " Delete Successfully");
			}else {
				System.out.println("Failed to delete !! try again "+currFile.getName());
			}
	}
	
}
