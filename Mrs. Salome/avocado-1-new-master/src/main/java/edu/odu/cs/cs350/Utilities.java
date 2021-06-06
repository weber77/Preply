package edu.odu.cs.cs350;

import java.io.File;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * 
 * @author dmays
 *	Add this to your .java by including the line
 *		import static edu.odu.cs.cs350.Utilities.*;
 *
 *	These functions were test previously before broken off from Snapshot.java
 *	
 */

public final class Utilities {

	/**
	 * 
	 * @param inputDirectory: File object with incoming csv file
	 * @return String fileName of the input csv directory
	 */
	public static String getCSVName(File inputDirectory) {
		String fileName = inputDirectory.getName();
		return fileName;
	}
	
	
	/**
	 * 
	 * @param input: String csv file, ex. "2018-06-25.csv"
	 * @return LocalDate object
	 */
	public static LocalDate getCSVDate(String input) {
		String fileDate = input;
		int extensionIndex = fileDate.indexOf(".csv");
		fileDate = fileDate.substring(0, extensionIndex);
		
		LocalDate date = null;
		try {
			date = LocalDate.parse(fileDate);
		} catch (DateTimeException e) {
			System.out.println(input);
			System.out.println(" The .csv title is not correctly formatted");
		}
		
		return date;
	}
	
	
}
