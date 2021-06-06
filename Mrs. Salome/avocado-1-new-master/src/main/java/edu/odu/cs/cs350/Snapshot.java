package edu.odu.cs.cs350;

import java.io.File;
import java.time.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import static edu.odu.cs.cs350.Utilities.*;


/** 
 * 
 * @author dmays
 * TODO -> Additional Javadoc (class, data members and methods)
 */

public class Snapshot {

	private File input;
	private LocalDate date;
	private List<Course> offeringTotals;
	// discuss date type
	private LocalDate snapDate;
	

	/**
	 * 
	 * @param inputCSV: file object
	 */
	// Non-default Constructor
	public Snapshot(File inputCSV) {
		input = inputCSV;
		String fileName = getCSVName(inputCSV);
		date = getCSVDate(fileName);
		offeringTotals = new ArrayList<>();
	}
	

	// Getters
	public File getInput() { return input; }
	public String getDate() { return date.toString(); }
	public Iterator<Course> getOfferings() { return offeringTotals.iterator(); }
	public int getCourseCount() { return offeringTotals.size(); }
	
	
	// Setter
	public void addOffering(Course c) {
		offeringTotals.add(c);
	}
	
	
	public void overwriteOfferings(List<Course> c) {
		offeringTotals.clear();
		offeringTotals = c;
	}
	

    public String toString() {
		return input.getPath();
    }


	public LocalDate getSnapDate() {
		return snapDate;
	}


	public void setSnapDate(LocalDate snapDate) {
		this.snapDate = snapDate;
	}
    
}
