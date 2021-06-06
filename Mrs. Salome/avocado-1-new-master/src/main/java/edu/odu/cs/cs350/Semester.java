package edu.odu.cs.cs350;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bwarren
 * 
 * Consists of courses that occur within a given time frame.
 * Can be historical (complete) or projecting (incomplete).
 */

/*
 * Modeled from Java Shapes Example 6 by Thomas Kennedy
 * cs330/reviews/Review-09-Java-Shapes/Example-6/
 */

public class Semester {
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Default Semester Constructor
	 * _semesterID = 0;
	 * _startPreRegistrationDate = 0000-01-01
	 * _registrationDeadline = 0000-01-02
	 * _registrationDays = 2
	 * @throws ParseException 
	 */
	public Semester() throws Exception {
		this._semesterID = "0";
		this._startPreRegistrationDate = LocalDate.parse("0000-01-01");
		this._registrationDeadline = LocalDate.parse("0000-01-02");
		this._registrationDays = 2;
		this.approvedSnapshots = null;
	}
	
	/**
     * Semester Non-Default Constructor.
     * @param ID = yyyyss
	 * @throws ParseException 
	 * @throws IOException 
     */
	public Semester(String ID) throws Exception
	{
		this._semesterID = ID;
		this._startPreRegistrationDate = LocalDate.parse("0000-01-01");
		this._registrationDeadline = LocalDate.parse("0000-01-02");
		this._registrationDays = 2;
		this.approvedSnapshots = null;
	}
    
    /**
	* Unique identifier for semester
	* format: YYYYSS
	* YYYY = the year in which the Fall semester begins
	*/
	private String _semesterID;
	
	/**
	 * First date listed within dates.txt
	 */
	private LocalDate _startPreRegistrationDate;
	
	/**
	 * Second date listed within dates.txt
	 */
	private LocalDate _registrationDeadline;
	
	/**
	 * Total days of registration, the window.
	 */
	private long _registrationDays;
	
	/**
	 * List of Snapshots that have received my seal of approval
	 */
	private List<Snapshot> approvedSnapshots;
	
	/**
     * Determine if there is more that one usable snapshot
     * If not, the program execution is aborted by throwing 
     * an IOException with the explanation Insufficient snapshots.
     * 
     * @return a container of acceptable snapshots
     * @throws IOException otherwise
     * @throws ParseException 
     */
	public List<Snapshot> readCSVs() throws Exception {
		readTextFile(_semesterID);
		
		File[] allCSVs = isolateSnapshots();
		
		List<Snapshot> acceptedSnapshots = filterSnapshots(allCSVs);
		
		verifySufficientSnapshots(allCSVs);

		return acceptedSnapshots;
	}
	
    /**
     * Read the "dates.txt" file within the Semester directory
     * 
     * @param semesterID
     * @throws Exception
     */
	public void readTextFile(String semesterID) throws Exception {
		//create a Path
		Path path = Paths.get("./src/test/java/edu/odu/cs/cs350/TestingResources/"
								+ semesterID + "/dates.txt"); 
		
		//read the file
		List<String> dateString = Files.readAllLines(path);

		//set _startPreRegistrationDate
		LocalDate start = LocalDate.parse(dateString.get(0));
		set_startPreRegistrationDate(start);
		
		//set _registrationDeadline
		LocalDate deadline = LocalDate.parse(dateString.get(1));
		set_registrationDeadline(deadline);
		
		//set _registrationDays
		long regDays = ChronoUnit.DAYS.between(start, deadline) + 1;
		set_registrationDays(regDays);
	}

	/**
	 * Separate all .csv files within the Semester directory
	 * @return a container of all .csv files therein
	 */
	public File[] isolateSnapshots() {
		//put all .csv files in a container
		//identify the directory by creating a file object
		File semDir = new File("/avocado-1-new/src/test/java/edu/odu/cs/cs350/"
								+ "TestingResources/" + _semesterID);
		
		//create a FileFilter
		FileFilter csvFiles = new FileFilter() {
			
			@Override
			public boolean accept(File semDir) {
				return semDir.getName().endsWith(".csv");
			}
		};
		
		//finally, the container
		File[] allCSVs = semDir.listFiles(csvFiles);
		return allCSVs;
	}

	/**
	 * Discriminate against Snapshots that are unworthy based on the date they were born.
	 * Call CSVParser.
	 * 
	 * @param allCSVs
	 * @return acceptable, parsed Snapshots
	 * @throws ParseException
	 */
	public List<Snapshot> filterSnapshots(File[] allCSVs) throws ParseException {
		//create a list of accepted snapshots
		List<Snapshot> acceptedSnapshots = new ArrayList<>();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		//examine the righteousness of the snapshot
		int counter = 0;
		for (File csvName : allCSVs) {
			//create a String.substring of the filename, dropping ".csv"
			String fileNameString = csvName.getName().substring(0, 10);
			//convert the filename substring to a LocalDate
			LocalDate csvDate = LocalDate.parse(fileNameString, dateFormat);
			//test for too early date
			if (csvDate.compareTo(_startPreRegistrationDate) < 0) {
				continue;
			}
			//test for first late date
			if (csvDate.compareTo(_registrationDeadline) > 0 && counter < 1) {
				counter++;
				//get them out of my life
				Snapshot goodCSV = new Snapshot(csvName);
//				CSVParser csvParser = new CSVParser(goodCSV);
				if (goodCSV != null) {
					acceptedSnapshots.add(goodCSV);
				}
			}
			//test for second late date
			if (csvDate.compareTo(_registrationDeadline) > 0 && counter > 0) {
				continue;
			} else {
				//get them out of my life
				Snapshot goodCSV = new Snapshot(csvName);
//				CSVParser csvParser = new CSVParser(goodCSV);
				if (goodCSV != null) {
					acceptedSnapshots.add(goodCSV);
				}
			}
		}
		set_ApprovedSnapshots(acceptedSnapshots);
		return acceptedSnapshots;
	}

	/**
	 * Verify more that one acceptable Snapshots exists
	 * @param allCSVs
	 * @throws IOException
	 */
	public void verifySufficientSnapshots(File[] allCSVs) throws IOException {
		//determine the virtue of the semester's snapshots
		if (allCSVs.length < 2) {
			throw new IOException("Insufficient snapshots");
		}
	}

	/**
	 * @return the _semesterID
	 */
	public String get_semesterID() {
		return _semesterID;
	}

	/**
	 * @param _semesterID the _semesterID to set
	 */
	public void set_semesterID(String _semesterID) {
		this._semesterID = _semesterID;
	}

	/**
	 * @return the _startPreRegistrationDate
	 */
	public LocalDate get_startPreRegistrationDate() {
		return _startPreRegistrationDate;
	}

	/**
	 * @param _startPreRegistrationDate the _startPreRegistrationDate to set
	 */
	public void set_startPreRegistrationDate(LocalDate _startPreRegistrationDate) {
		this._startPreRegistrationDate = _startPreRegistrationDate;
	}

	/**
	 * @return the _registrationDeadline
	 */
	public LocalDate get_registrationDeadline() {
		return _registrationDeadline;
	}

	/**
	 * @param _registrationDeadline the _registrationDeadline to set
	 */
	public void set_registrationDeadline(LocalDate _registrationDeadline) {
		this._registrationDeadline = _registrationDeadline;
	}

	/**
	 * @return the _registrationDays
	 */
	public long get_registrationDays() {
		return _registrationDays;
	}

	/**
	 * @param regDays the _registrationDays to set
	 */
	public void set_registrationDays(long regDays) {
		this._registrationDays = regDays;
	}

	/**
	 * @return the approvedSnapshots
	 */
	public List<Snapshot> get_ApprovedSnapshots() {
		return approvedSnapshots;
	}

	/**
	 * @param approvedSnapshots the approvedSnapshots to set
	 */
	public void set_ApprovedSnapshots(List<Snapshot> approvedSnapshots) {
		this.approvedSnapshots = approvedSnapshots;
	}
}
