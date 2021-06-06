/**
 * 
 */
package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bwarren
 *
 */
public class SemesterTest {
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	File[] snapshots = {
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2020-10-18.csv"),
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2020-10-19.csv"),
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2020-12-01.csv"),
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2021-01-17.csv"),
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2021-01-26.csv"),
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2021-01-27.csv"),
			new File("./src/test/java/edu/odu/cs/cs350/TestingResources/202020/2021-01-28.csv")
	};
	
	
	String semID = "202020";
	
	Semester sem;
	Semester semWithID;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		String constRegStart = "0000-01-01";
//		String constDeadline = "0000-01-02";
//		String actRegStart = "2020-10-19";
//		String actDeadline = "2021-01-26";
//		
//		Date constStart = dateFormat.parse(constRegStart);
//		Date constEnd = dateFormat.parse(constDeadline);
//		Date actStart = dateFormat.parse(actRegStart);
//		Date actEnd = dateFormat.parse(actDeadline);
//		
		sem = new Semester();
		semWithID = new Semester(semID);
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#Semester()}.
	 * @throws Exception 
	 */
	@Test
	public void testDefaultConstructor() throws Exception {
		assertEquals("0", sem.get_semesterID());
		assertEquals(LocalDate.parse("0000-01-01"), sem.get_startPreRegistrationDate());
		assertEquals(LocalDate.parse("0000-01-02"), sem.get_registrationDeadline());
		assertEquals(2, sem.get_registrationDays());
		assertEquals(null, sem.get_ApprovedSnapshots());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#Semester(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testNonDefaultConstructor() throws Exception {
		assertEquals("202020", semWithID.get_semesterID());
		assertEquals(LocalDate.parse("0000-01-01"), semWithID.get_startPreRegistrationDate());
		assertEquals(LocalDate.parse("0000-01-02"), semWithID.get_registrationDeadline());
		assertEquals(2, semWithID.get_registrationDays());
		//size should be 5, may need to test for correctness
		assertEquals(null, semWithID.get_ApprovedSnapshots());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#readCSVs()}.
	 */
	@Test
	public void testReadCSVs() {
		//tested via Non-Default Constructor
		
		//-------------accessors---------------
		//public String get_semesterID()
		//public Date get_startPreRegistrationDate()
		//public Date get_registrationDeadline()
		//public int get_registrationDays()
		//public List<Snapshot> getApprovedSnapshots()
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#readTextFile(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testReadTextFile() throws Exception {
		semWithID.readTextFile(semID);
		
		assertEquals("202020", semWithID.get_semesterID());
		assertEquals(LocalDate.parse("2020-10-19"), semWithID.get_startPreRegistrationDate());
		assertEquals(LocalDate.parse("2021-01-26"), semWithID.get_registrationDeadline());
		assertEquals(100, semWithID.get_registrationDays());
		//size should be null, may need to test for correctness
		assertEquals(null, semWithID.get_ApprovedSnapshots());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#isolateSnapshots()}.
	 * @throws Exception 
	 */
	@Test
	public void testIsolateSnapshots() throws Exception {
		semWithID.readTextFile(semID);
		semWithID.isolateSnapshots();

		assertEquals("202020", semWithID.get_semesterID());
		assertEquals(LocalDate.parse("2020-10-19"), semWithID.get_startPreRegistrationDate());
		assertEquals(LocalDate.parse("2021-01-26"), semWithID.get_registrationDeadline());
		assertEquals(100, semWithID.get_registrationDays());
		//size should be 7, may need to test for correctness
		assertEquals(null, semWithID.get_ApprovedSnapshots());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#filterSnapshots(java.io.File[])}.
	 * @throws Exception 
	 */
	@Test
	public void testFilterSnapshots() throws Exception {
		semWithID.readTextFile(semID);
		semWithID.isolateSnapshots();
		semWithID.filterSnapshots(snapshots);

		assertEquals("202020", semWithID.get_semesterID());
		assertEquals(LocalDate.parse("2020-10-19"), semWithID.get_startPreRegistrationDate());
		assertEquals(LocalDate.parse("2021-01-26"), semWithID.get_registrationDeadline());
		assertEquals(100, semWithID.get_registrationDays());
		//size should be 5, may need to test for correctness
		assertEquals(5, semWithID.get_ApprovedSnapshots().size());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#verifySufficientSnapshots(java.io.File[])}.
	 */
	@Test
	public void testVerifySufficientSnapshots() {
		//-------------accessors---------------
		//public String get_semesterID()
		//public Date get_startPreRegistrationDate()
		//public Date get_registrationDeadline()
		//public int get_registrationDays()
		//public List<Snapshot> getApprovedSnapshots()
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#set_semesterID(java.lang.String)}.
	 */
	@Test
	public void testSet_semesterID() {
		assertEquals("0", sem.get_semesterID());
		assertEquals("202020", semWithID.get_semesterID());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#set_startPreRegistrationDate(java.util.Date)}.
	 * @throws Exception 
	 */
	@Test
	public void testSet_startPreRegistrationDate() throws Exception {
		assertEquals(LocalDate.parse("0000-01-01"), sem.get_startPreRegistrationDate());
		assertEquals(LocalDate.parse("0000-01-01"), semWithID.get_startPreRegistrationDate());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#set_registrationDeadline(java.util.Date)}.
	 * @throws Exception 
	 */
	@Test
	public void testSet_registrationDeadline() throws Exception {
		assertEquals(LocalDate.parse("0000-01-02"), sem.get_registrationDeadline());
		assertEquals(LocalDate.parse("0000-01-02"), semWithID.get_registrationDeadline());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#set_registrationDays(int)}.
	 */
	@Test
	public void testSet_registrationDays() {
		assertEquals(2, sem.get_registrationDays());
		assertEquals(2, semWithID.get_registrationDays());
	}

	/**
	 * Test method for {@link edu.odu.cs.cs350.Semester#setApprovedSnapshots(java.util.List)}.
	 */
	@Test
	public void testSetApprovedSnapshots() {
		assertEquals(null, sem.get_ApprovedSnapshots());
		//size should be 7, may need to test for correctness
		assertEquals(null, semWithID.get_ApprovedSnapshots());
	}

	//-------------accessors---------------
	//public String get_semesterID()
	//public Date get_startPreRegistrationDate()
	//public Date get_registrationDeadline()
	//public int get_registrationDays()
	//public List<Snapshot> getApprovedSnapshots()
}
