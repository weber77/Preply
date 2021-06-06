package edu.odu.cs.cs350;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

/**
 * @author dmays
 */

/**
 * 
 */
public class CSVParser {
	// TODO -> Document Each of Data Members
	public List<Course> snapshot;
	public List<Course> coursesData;
	private CSVReader reader;
	
	
	// Default Constructor
	public CSVParser() {
		
	}
	
	
	/**
	 * TODO -> Provide description of what it does
	 * @param csvFile: Snapshot which includes file object, date, and empty course container
	 */
	public CSVParser(Snapshot csvFile) {
		File file = csvFile.getInput();
		try {
			CsvToBean<Course> beans =
					new CsvToBeanBuilder<Course>(new FileReader(file))
					.withType(Course.class)
					.withThrowExceptions(false)
					.build();
			
			snapshot = beans.parse();
			beans.getCapturedExceptions().stream().forEach((exception) -> {
				System.out.println("Some Exception" + exception.getLine() + " - " +  exception);
			});
		} catch (FileNotFoundException e) {
			System.out.println(csvFile.toString());
			System.out.println(" is invalid or missing \n");
		}
			
			/* Old Parser Code
		try {
			snapshot = new CsvToBeanBuilder(new FileReader(
					csvFile.getInput())).withType(Course.class)
					.withThrowExceptions(false).build().parse();
			.getCapturedExceptions()
		} catch (FileNotFoundException e) {
			System.out.println(csvFile.toString());
			System.out.println(" is invalid or missing \n");
		}
		*/
		// Concatenate each course name
		for ( Course c : snapshot) {
			c.concatCourseName();
		}
		
		aggregateCourses();
		csvFile.overwriteOfferings(coursesData);
	}

	
	/**
	 * TODO -> Add proper javadoc
	 */
	public void aggregateCourses() {
		HashSet<Course> set = new HashSet<>();
		coursesData = new ArrayList<Course>();
		
		for ( Course c : snapshot ) {
			if (!(set.contains(c))) { // This should use my overloaded equals()
				coursesData.add(c);
				set.add(c);
			}
		}
				
	}
}