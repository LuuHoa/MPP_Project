package dataaccess.storge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.Address;
import business.Book;
import business.BookCopy;
import business.CheckOutEntry;
import business.CheckoutRecord;
import business.LibraryMember;
import business.LibraryStaff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataAccessService {

	//private static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/dataaccess/storge/";
	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/data/";
	
	enum StorageType {
		USERS, BOOKS, MEMBERS, RECORD;
	}

	public static List<Book> allBooks;
	public static List<LibraryMember> allMembers;
	public static List<CheckoutRecord> allRecords;
	

	public static List<LibraryStaff> getLibaryMembers() {

		List<LibraryStaff> staffList = (List<LibraryStaff>) (Object) ReadObjectFromFile(OUTPUT_DIR + StorageType.USERS);
		return staffList;

	}

	// All Member operations
	public static void loadAllMembers() {
		allMembers = ((List<LibraryMember>) (Object) ReadObjectFromFile(OUTPUT_DIR + StorageType.MEMBERS));
		if (allMembers == null) allMembers = new ArrayList<>();
	}

	public static void saveAllMembers() {
		WriteObjectToFile(OUTPUT_DIR + StorageType.MEMBERS, (List<Object>) (Object) allMembers);
	}

	public static LibraryMember getMember(String ID) {
		for (LibraryMember m : allMembers) {
			if (m.getId().equals(ID))
				return m;
		}
		return null;
	}

	// All book operations
	public static void loadAllBooks() {
		allBooks = ((List<Book>) (Object) ReadObjectFromFile(OUTPUT_DIR + StorageType.BOOKS));
		if (allBooks == null) allBooks = new ArrayList<>();
	}

	public static void saveAllBooks() {
		WriteObjectToFile(OUTPUT_DIR + StorageType.BOOKS, (List<Object>) (Object) allBooks);
	}

	public static Book getBook(String isbn) {
		for (Book b : allBooks) {
			if (b.getISBN().equals(isbn))
				return b;
		}
		return null;
	}

	public static void loadAllRecords() {
		allRecords = ((List<CheckoutRecord>) (Object) ReadObjectFromFile(OUTPUT_DIR + StorageType.RECORD));
		if(allRecords == null) allRecords = new ArrayList<>();
	}

	public static void saveAllRecords() {
		WriteObjectToFile(OUTPUT_DIR + StorageType.RECORD, (List<Object>) (Object) allRecords);
	}

	public static void addNewBook(Book book) {
//		List<Object> memberList = ReadObjectFromFile(OUTPUT_DIR + StorageType.BOOKS);
//		memberList.add(book);
//
//		WriteObjectToFile(OUTPUT_DIR + StorageType.BOOKS, memberList);
		allBooks.add(book);
		saveAllBooks();
	}

	public static List<LibraryMember> getMemberLists() {
		return ((List<LibraryMember>) (Object) ReadObjectFromFile(OUTPUT_DIR + StorageType.MEMBERS));
	}

	public static void addNewMenber(LibraryMember member) {
		allMembers.add(member);
		saveAllMembers();
	}

	public static void simulateData() {
//
/*		LibraryStaff s = new LibraryStaff("11", "123", "Admin");

		LibraryStaff s2 = new LibraryStaff("22", "123", "Librarian");
		LibraryStaff s3 = new LibraryStaff("33", "123", "Both");
		
		LibraryStaff s4 = new LibraryStaff("admin", "123", "Admin");

		LibraryStaff s5 = new LibraryStaff("lib", "123", "Librarian");
		LibraryStaff s6 = new LibraryStaff("both", "123", "Both");

		List<Object> objectList = new ArrayList<>();
		objectList.add(s);
		objectList.add(s2);
		objectList.add(s3);
		objectList.add(s4);
		objectList.add(s5);
		objectList.add(s6);
		WriteObjectToFile(OUTPUT_DIR + StorageType.USERS, objectList);*/
//
/*		List<Object> lm = new ArrayList<>();
		LibraryMember mem1 = new LibraryMember("01", "Mai", "Tran",
				new Address("620 Gonzales Drive", "Long Beach", "NY", "11561"), "1898856");
		LibraryMember mem2 = new LibraryMember("02", "Edman", "Mohammed",
				new Address("9268 Arcadia Dr", "Lakewood", "NJ", "08701"), "745242452");
		LibraryMember mem3 = new LibraryMember("03", "Hoa", "Luu",
				new Address("7807 Lees Creek Street", "Upper Marlboro", "MD", "20772"), "4587545254");
		LibraryMember mem4 = new LibraryMember("04", "Hai", "Orsi",
				new Address("8157 Heather Drive", "Tampa", "FL", "33604"), "5324568");
		LibraryMember mem5 = new LibraryMember("05", "Tom", "Jerry",
				new Address("75 Deerfield Rd", "Boca Raton", "FL", "33428"), "8524254");
		lm.add(mem1);
		lm.add(mem2);
		lm.add(mem3);
		lm.add(mem4);
		lm.add(mem5);
		WriteObjectToFile(OUTPUT_DIR + StorageType.MEMBERS, lm);*/
//
//		List<Object> lm2 = new ArrayList<>();
//		Book b1 = new Book("0061964361", 21, "Book 1", null);
//		Book b2 = new Book("0061964362", 7, "Book 2", null);
//		Book b3 = new Book("0061964363", 21, "Book 3", null, 2);
//		Book b4 = new Book("0061964364", 7, "Book 4", null, 2);
//		lm2.add(b1);
//		lm2.add(b2);
//		lm2.add(b3);
//		lm2.add(b4);
//		WriteObjectToFile(OUTPUT_DIR + StorageType.BOOKS, lm2);
//
//		List<Object> lm3 = new ArrayList<>();
//		CheckOutEntry en1 = new CheckOutEntry(LocalDate.now(), b1.getNextCopy());
//		CheckOutEntry en2 = new CheckOutEntry(LocalDate.now(), b2.getNextCopy());
//		CheckOutEntry en3 = new CheckOutEntry(LocalDate.now(), b3.getNextCopy());
//		CheckoutRecord cr = new CheckoutRecord(mem1);
//		cr.addEntry(en1);
//		cr.addEntry(en2);
//		cr.addEntry(en3);
//		lm3.add(cr);
//		System.out.println(cr);
//		WriteObjectToFile(OUTPUT_DIR + StorageType.RECORD, lm3);
	}

	private static void WriteObjectToFile(String filepath, List<Object> serObj) {

		try {

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(serObj);
			objectOut.close();
			//System.out.println("The Object  was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static List<Object> ReadObjectFromFile(String filepath) {

		try {

			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			List<Object> objectList = (List<Object>) objectIn.readObject();
			//System.out.println("The Object has been read from the file");
			objectIn.close();
			return objectList;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static ObservableList<Book> ReadBookFromFile() {

		try {
			List<Object> books = ReadObjectFromFile(OUTPUT_DIR + StorageType.BOOKS);
			List<Book> arrbooks = new ArrayList<Book>();
			for (Object book : books) {
				arrbooks.add((Book) book);
			}

			ObservableList<Book> results = FXCollections.observableArrayList(arrbooks);
			return results;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
