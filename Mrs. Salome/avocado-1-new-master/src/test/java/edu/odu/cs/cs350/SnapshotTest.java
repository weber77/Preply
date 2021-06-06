package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class SnapshotTest {

	Snapshot ohSnap;
	File csvFile;
	Course testCourse;
	Course testCourse2;
	private List<Course> testList;
	
	@Before
	public void setUp() throws Exception {
		csvFile = new File("./src/test/java/edu/odu/cs/cs350/TestingResources/2017-08-21.csv");
		ohSnap = new Snapshot(csvFile);
		
		// Setup testCourse attributes
		testCourse = new Course();
		testCourse.setSeats(2);
		testCourse.setCRN(101);
		testCourse.setSubject("CS");
		testCourse.setCourseNumber("101G");
		testCourse.setTitle("Intro to CS");
		testCourse.setCourseName("CS101G");
		
		testCourse2 = new Course();
		testCourse2.setSeats(3);
		testCourse2.setCRN(102);
		testCourse2.setSubject("CS");
		testCourse2.setCourseNumber("120G");
		testCourse2.setTitle("Test");
		testCourse2.setCourseName("CS120G");
		
	}

	@Test
	public void testNonDefaultConstructor() {
		assertThat(ohSnap.getInput(), is(equalTo(csvFile)));
		assertThat(ohSnap.getDate(), is("2017-08-21"));
	}		
	
	@Test
	public void testAddOffering() {
		ohSnap.addOffering(testCourse);
		assertThat(ohSnap.getCourseCount(), is(1));
		
		//test iterator and getters
		Iterator<Course> itr = ohSnap.getOfferings();
		Course itrCourse = itr.next();
		assertThat(itrCourse.getSeats(), is(2));
		assertThat(itrCourse.getCRN(), is(101));
		assertThat(itrCourse.getSubject(), is("CS"));
		assertThat(itrCourse.getCourseNumber(), is("101G"));
		assertThat(itrCourse.getTitle(), is("Intro to CS"));
		assertThat(itrCourse.getCourseName(), is("CS101G"));
	}
	
		
	@Test
	public void testOverwriteOfferings() {
		ohSnap.addOffering(testCourse);
		assertThat(ohSnap.getCourseCount(), is(1));
		testList = new ArrayList<Course>();
		testList.add(testCourse2);
		ohSnap.overwriteOfferings(testList);
		assertThat(ohSnap.getCourseCount(), is(1));
		Iterator<Course> itr = ohSnap.getOfferings();
		Course itrCourse = itr.next();
		assertThat(itrCourse.getSeats(), is(3));
		assertThat(itrCourse.getCourseNumber(), is("120G"));
		
	}

}
