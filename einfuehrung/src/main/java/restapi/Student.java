package restapi;

import java.util.List;

public class Student {

	private final long mtrNumber;
	private final String firstName;
	private final String lastName;
	private final List<Course> courses;
	private final List<Course> finishedCourses;

	public Student(long mtrNumber, String firstName, String lastName, List<Course> courses, List<Course> finishedCourses) {
	   this.mtrNumber = mtrNumber;
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.courses = courses;
	   this.finishedCourses = finishedCourses;
	}

	public long getMtrNumber() {
		return mtrNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}
}