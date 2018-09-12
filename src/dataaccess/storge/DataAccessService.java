package dataaccess.storge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.Address;
import business.Book;
import business.LibraryMember;
import business.LibraryStaff;

public class DataAccessService {

	private static final String bookFilepath="docs/book.txt";
	private static final String checkoutFilepath="docs/checkout.txt";
	private static final String userFilepath = "src/dataaccess/storge/user.txt";
	private static final String memberFilepath = "src/dataaccess/storge/member.txt";
	
	public static List<LibraryStaff> getLibaryMembers() {
		
		List<LibraryStaff> staffList = (List<LibraryStaff>)(Object)ReadObjectFromFile(userFilepath);
		return staffList;
		
	} 
	
	public static List<Book> getBookLists() {
		return ((List<Book>) (Object) ReadObjectFromFile(bookFilepath));
	}
	
	public static List<LibraryMember> getMemberLists() {
		return ((List<LibraryMember>) (Object) ReadObjectFromFile(memberFilepath));
	}

	public static void addNewMenber(LibraryMember member) {
		List<Object> memberList = ReadObjectFromFile(memberFilepath);
		memberList.add(member);

		WriteObjectToFile(memberFilepath, memberList);
	}
	
	public static boolean isValidMemberID(String ID) {
		List<LibraryMember> li = getMemberLists();
		for (LibraryMember m : li) {
			if(m.getId().equals(ID)) return true;
		}
		return false;
	}
	
	public static LibraryMember getMemeber(String ID) {
		List<LibraryMember> li = getMemberLists();
		for (LibraryMember m : li) {
			if(m.getId().equals(ID)) return m;
		}
		return null;
	}
	
	public static boolean isBookAvailable(String isbn) {
		List<Book> li = getBookLists();
		for (Book b : li) {
			if(b.getISBN().equals(isbn) && b.getNumTotalCopies() > 0) return true; 
		}
		return false;
	}
	
	public static Book getBook(String isbn) {
		List<Book> li = getBookLists();
		for (Book m : li) {
			if(m.getISBN().equals(isbn)) return m;
		}
		return null;
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

//			Address address1 = new Address("1 st", "Fairfield", "Iowa", "234");
//			LibraryMember member1 = new LibraryMember("0", "Eman", "Mohammed", address1, "123456789");
//			Address address2 = new Address("2 st", "Fairfield", "Iowa", "234");
//			LibraryMember member2 = new LibraryMember("1", "Thi Quynh", "Mai Tran", address2, "123456789");
//			Address address3 = new Address("3 st", "Fairfield", "Iowa", "234");
//			LibraryMember member3 = new LibraryMember("2", "Thi Kim Hoa ", "Luu", address3, "123456789");
//			Address address4 = new Address("4 st", "Fairfield", "Iowa", "234");
//			LibraryMember member4 = new LibraryMember("0", "Ali", "Mohammed", address4, "123456789");
//
//			List<Object> objectList2 = new ArrayList<>();
//			objectList2.add(member1);
//			objectList2.add(member2);
//			objectList2.add(member3);
//			objectList2.add(member4);
//			WriteObjectToFile(memberFilepath, objectList2);
			
			// To be removed
			List<Object> lm = new ArrayList<>();
			lm.add(new LibraryMember("0", "Hai", "Orsi", new Address("620 Gonzales Drive", "Long Beach", "NY", "11561"), "123456789"));
			lm.add(new LibraryMember("1", "Hai", "Orsi", new Address("9268 Arcadia Dr", "Lakewood", "NJ", "08701"), "123456789"));
			lm.add(new LibraryMember("2", "Hai", "Orsi", new Address("7807 Lees Creek Street", "Upper Marlboro", "MD", "20772"), "123456789"));
			lm.add(new LibraryMember("3", "Hai", "Orsi", new Address("8157 Heather Drive", "Tampa", "FL", "33604"), "123456789"));
			lm.add(new LibraryMember("4", "Hai", "Orsi", new Address("75 Deerfield Rd", "Boca Raton", "FL", "33428"), "123456789"));
			System.out.println(lm);
			WriteObjectToFile(memberFilepath, lm);
			
			List<Object> lm2 = new ArrayList<>();
			lm2.add(new Book("0061964361", 21, "Book 1", null));
			lm2.add(new Book("0061964362", 7, "Book 2", null));
			lm2.add(new Book("0061964363", 21, "Book 3", null,2));
			lm2.add(new Book("0061964364", 7, "Book 4", null,2));
			System.out.println(lm2);
			WriteObjectToFile(bookFilepath, lm2);
			// End		   
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
	
	public static void main(String[] args) {
		simulateData();
	}
	
}
