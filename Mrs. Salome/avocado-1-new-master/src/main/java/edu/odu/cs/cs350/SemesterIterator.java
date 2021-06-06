/**
 * 
 */
package edu.odu.cs.cs350;

import java.awt.Shape;
import java.io.BufferedReader;
import java.util.Iterator;

/**
 * @author bwarren
 * 
 * Iterator over a buffer of Semester objects. This iterator stops when
 * Buffer is exhausted. Invalid Semester objects (null) are skipped.
 */

/*
 * Modeled from Java Shapes Example 6 by Thomas Kennedy
 * cs330/reviews/Review-09-Java-Shapes/Example-6/
 */
public class SemesterIterator implements Iterator<Semester>{

	/**
     * Source buffer from which Semester objects are read.
     */
    private BufferedReader theBuffer;
    
    /**
     * Store the next pre-read Semester.
     */
    private Semester queued;
    
    /**
     * Construct a SemesterIterator of an input buffer.
     *
     * @param buffer semester data buffer
     */
	public SemesterIterator(BufferedReader buffer) {
		// TODO Auto-generated constructor stub
	}
	
	
	//@Override 
	public boolean hasNext() { 
		return queued != null; 
	}

	/**
	 * While Loop
	 * 	taking semester
	 * 	while sem == null && validDates == True
	 * 	sem = semesterFactory.createSemester(semesterID)
	 * 
	 * Go to SemesterFactory
	 */
	private Semester readNext() {
		return null;
		
	}
	/**
	 * Semester sem = queued;
	 * queued = readNext();
	 * 
     * 	call collection.add(semester)
	 */

	//@Override 
	public Semester next() {
		return queued;
		
	}

}
