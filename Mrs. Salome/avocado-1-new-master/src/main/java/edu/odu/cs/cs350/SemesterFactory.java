/**
 * 
 */
package edu.odu.cs.cs350;

/**
 * @author bwarren
 *
 * The Semester Creating Wizard
 */

/*
 * Modeled from Java Shapes Example 6 by Thomas Kennedy
 * cs330/reviews/Review-09-Java-Shapes/Example-6/
 */
public class SemesterFactory {

	/**
	 * 
	 * @param semesterID
	 * 
	 * How to identify what is a historical vs current/projecting semester?
	 * 
	 */
	public static Semester createSemester(String semesterID) {
		/**
		 * Semester newSemester;
		 * 
		 * if (semesterID == commandLineArg1)
		 * 	newSemester = new HistoricalSemester(semesterID)
		 * else 
		 * 	newSemester = new ProjectingSemester(semesterID)
		 * 
		 * return newSemester
		 */
		return null;
	}

	public static boolean semesterDatesArePresent(String start, String deadline) {
		return true;
	}
}
