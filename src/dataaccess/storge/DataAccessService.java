package dataaccess.storge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.LibraryStaff;

public class DataAccessService {
	private static final String userFilepath="docs/user.txt";
	private static final String bookFilepath="docs/book.txt";


	public static List<LibraryStaff> getLibaryMembers() {
		
		List<LibraryStaff> staffList = (List<LibraryStaff>)(Object)ReadObjectFromFile(userFilepath);
		return staffList;
		
	} 
	
	public static void simulateData() {
		   LibraryStaff s = new LibraryStaff("11", "123", "Admin");
		   
		   LibraryStaff s2 = new LibraryStaff("22", "123", "Librarian");
		   LibraryStaff s3 = new LibraryStaff("33", "123", "Both");
		   
		   List<Object> objectList = new ArrayList<>();
		   objectList.add(s);
		   objectList.add(s2);
		   objectList.add(s3);
		   WriteObjectToFile(userFilepath, objectList);
	}
	private static void WriteObjectToFile(String filepath,List<Object> serObj) {

		try {

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			  objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println("The Object  was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static List<Object> ReadObjectFromFile(String filepath) {

		try {

			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);


			List<Object> objectList = (List<Object>)objectIn.readObject();
			System.out.println("The Object has been read from the file");
			objectIn.close();
			return objectList;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
