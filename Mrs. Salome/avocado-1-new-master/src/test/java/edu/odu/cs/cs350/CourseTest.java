/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dmays
 *  @see SnapshotTest.java and CSVParserTest.java - Getters and Setters tested thoroughly there
 */
public class CourseTest {

	Course element;
	
	@Before
	public void setUp() throws Exception {
		element = new Course();
	}

	@Test
	public void testDefaultConstructor() {
		assertThat(element.getOfferingCapacity(), is(0));
		assertThat(element.getOfferingEnrollment(), is(0));
		element.addToOfferingCapacity(2);
		element.addToOfferingEnrollment(3);
		assertThat(element.getOfferingCapacity(), is(2));
		assertThat(element.getOfferingEnrollment(), is(3));
	}
	
	@Test
	public void testConcatCourseName() {
		element.setSubject("CS");
		element.setCourseNumber("101G");
		element.concatCourseName();
		assertThat(element.getCourseName(), is("CS101G"));
		element.setCourseName("CS120G");
		Course c = new Course();
		c.setCourseName("CS120G");
		assertThat(element.equals(c), is(true));
	}
}
