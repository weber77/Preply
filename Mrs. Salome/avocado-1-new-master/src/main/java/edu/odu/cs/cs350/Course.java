package edu.odu.cs.cs350;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvValidationException;

/** 
 * @author dmays
 * TODO -> Additional Javadoc (class, data members and methods)
 */
public class Course {

	public Course() {
		offeringCapacity = 0;
		offeringEnrollment = 0;
	}

	private String courseName;

	@CsvBindByName(column = "Seats", required = true)
	private int seats;
	
	@CsvBindByName(column = "CRN", required = true)
	private int CRN;
	
	@CsvBindByName(column = "SUBJ", required = true)
	private String subject;
	
	@CsvBindByName(column = "CRSE", required = true)
	private String courseNumber;
	
	@CsvBindByName(column = "TITLE")
	private String title;
	
	@CsvBindByName(column = "XLST CAP")
	private int sectionCapacity;
	
	@CsvBindByName(column = "ENR")
	private int sectionEnrollment;
	
	@CsvBindByName(column = "LINK")
	private String link;
	
	
	// Important for aggregating
	// Which offering does this section belong to?
	// Blank means it is the only section in the offering
	// Nonempty -> all sections with same SUBJ, CRSE, and XLST Group comprise a single offering
	@CsvBindByName(column = "XLST GROUP")
	private String sectionGroup;

	@CsvBindByName(column = "OVERALL CAP")
	private int offeringCapacity;
	
	@CsvBindByName(column = "OVERALL ENR")
	private int offeringEnrollment;
	
	
	// These will house total capacity and enrollment for the aggregate
	// These refer to the overall offering's (all sections) totals
	
	public int getSeats() { return seats; }
	public int getCRN() { return CRN; }
	public String getSubject() { return subject; }
	public String getCourseNumber() { return courseNumber; }
	public String getTitle() { return title; }
	public String getCourseName() { return courseName; }
	public int getSectionCapacity() { return sectionCapacity; }
	public int getSectionEnrollment() { return sectionEnrollment; }
	public int getOfferingCapacity() { return offeringCapacity; }
	public int getOfferingEnrollment() { return offeringEnrollment; }
	public String getSectionGroup() { return sectionGroup; }
	
	public void setSeats(int s) { seats = s; }
	public void setCRN(int c) { CRN = c; }
	public void setCourseNumber(String crse) { courseNumber = crse; }
	public void setTitle(String t) { title = t; }
	public void setSubject(String s) { subject = s; }
	public void setOfferingCapacity(int e) { offeringCapacity = e; }
	public void setOfferingEnrollment(int e) { offeringEnrollment = e; }

	public void setCourseName(String name) { courseName = name;	}
	public void concatCourseName() {
		setCourseName(subject + courseNumber);
	}
	
	/** 
	 * Add to enrollment capacity and current overall enrollment
	 * @param: additional seats/enrollment
	 */
	public void addToOfferingCapacity(int e) { offeringCapacity += e; }
	public void addToOfferingEnrollment(int e) { offeringEnrollment += e; }
	
	public String toString() {
		return courseNumber;
	}
	
	
	public boolean isALecture() {
		if (link == null || link.isBlank())
			return true;
		if (link.charAt(1) == '1')
			return true;
		return false;
	}

	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Course))
			return false;
		
		Course c = (Course)o;
		
		if (c.getCourseName() == this.getCourseName() 
				&& c.getSectionGroup() == this.getSectionGroup())
			return true;
				
		return false;
	}
	
}
