package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;


/**
 * @author dmays
 * 
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */

public class CSVParserTest {

	CSVParser parseIt;
	Course testCourse;
	Snapshot testInput;
	Iterator<Course> itr;
	
	@Before
	public void setUp() throws Exception {
		File csvFile = new File("./src/test/java/edu/odu/cs/cs350/TestingResources/2017-08-21.csv");
		// Snapshot non-default constructor (tested)
		testInput = new Snapshot(csvFile); 
		parseIt = new CSVParser(testInput);
		itr = parseIt.snapshot.iterator();
	}

	@Test
	public void testDefaultConstructor() {
		parseIt = new CSVParser();
	}
	
	@Test
	public void testNonDefaultConstructor() {
		// Test first row of CSV
		Course firstCourse = (Course)itr.next();
		assertThat(parseIt.snapshot.size(), is(59));
		assertThat(firstCourse.getSeats(), is(0));
		assertThat(firstCourse.getCRN(), is(23182));
		assertThat(firstCourse.getSubject(), is("CS"));
		assertThat(firstCourse.getCourseNumber(), is("120G"));
		assertThat(firstCourse.getTitle(), is("First Title"));
		// Increment to second row of CSV
		Course secondCourse = (Course)itr.next();
		assertThat(secondCourse.getTitle(), is("Second Title"));
		assertThat(secondCourse.getSectionCapacity(), is(25));
		assertThat(secondCourse.getSectionEnrollment(), is(8));
		assertThat(secondCourse.getCourseName(), is("CS120G"));
		// Test Link Code --> Is it a lecture?
		assertThat(firstCourse.isALecture(), is(true));
		assertThat(secondCourse.isALecture(), is(false));
		Course thirdCourse = (Course)itr.next();
		assertThat(thirdCourse.isALecture(), is(true));
		// Test that snapshot's list of courses is updated
		// This will fail if there is a change to the test data
		// will fail when inclusion/exclusion logic is implemented for aggregation
		assertThat(parseIt.snapshot.size(), is(59));
	}
	
	
	@Test
	public void testAggregateCourses() {
		assertThat(parseIt.snapshot.isEmpty(), is(false));
		parseIt.aggregateCourses();
		// This will fail if there is a change to the test data
		// will fail when inclusion/exclusion logic is implemented for aggregation
		assertThat(parseIt.coursesData.size(), is(59));
	}

	/*
	
	@Test
	public void testSummingUpCourses() {
		//String
		String filePath = "./src/test/java/edu/odu/cs/cs350/TestingResources/2017-08-21.csv";
		File testCSV = new File(filePath);
		
		Snapshot sampleInput = new Snapshot(testCSV);
		
		CSVParser parser = new CSVParser(sampleInput);
		
		Iterator<Course> sit;
		Iterator<Course> cit;		
		
		sit = parser.snapshot.iterator();
		cit = parser.coursesData.iterator();
		
		int index = 0;
		//basic test to see if two courses are being added correctly
		parser.snapshot.add(parser.coursesData.get(0));
		assertThat(parser.snapshot.get(0), is(25));
		//cit.next();
		parser.snapshot.add(parser.coursesData.get(1));
		assertThat(parser.snapshot.get(0), is(50));
		assertThat(parser.snapshot.get(1), is(false)); //make sure that a second course was not added
		
		//test if offering of the same XLST GROUP add up 
		//cit.next();
		parser.snapshot.add(parser.coursesData.get(2));
		assertThat(parser.snapshot.get(0), is(90));
		assertThat(parser.snapshot.get(1), is(false));
		
		parser.snapshot.add(parser.coursesData.get(3));
		assertThat(parser.snapshot.get(0), is(130));
		assertThat(parser.coursesData.get(1), is(false));
		
		
		
	}
	*/
	
}













