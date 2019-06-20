package restapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {

	private static List<Student> students = new ArrayList<>();
	private static List<Course> courses = new ArrayList<>();

	static {
	    // Initializes the data of our model
		Course course0 = new Course("c0", "JSF", "Learn JSF.", null);
		Course course1 = new Course("c1", "Maven", "One of the most popular dependency management tools.", null);
		Course course2 = new Course("c2", "Web Servers", "Learn about web servers.", null);

	    List<Course> courseList0 = new LinkedList<>();
	    courseList0.add(course1);
        courseList0.add(course2);
		Course course3 = new Course("c3", "Spring Boot", "Use Spring Boot to bootstrap servers.", courseList0);


		List<Course> courseList1 = new LinkedList<>();
        courseList1.addAll(courseList0);
        courseList1.add(course3);
		Course course4 = new Course("c4", "Spring Data", "A course about data persistence on the server.", courseList1);

	    courses.add(course0);
	    courses.add(course1);
	    courses.add(course2);
	    courses.add(course3);
	    courses.add(course4);

        List<Course> courseList2 = new LinkedList<>();
        courseList2.add(course0);
        courseList2.add(course1);

        List<Course> courseList3 = new LinkedList<>();
        courseList3.add(course3);

        List<Course> courseList4 = new LinkedList<>();
        courseList4.add(course0);

	    Student student0 = new Student(23328, "Max", "Muster", courseList2, null);
	    Student student1 = new Student(34622, "Hans", "Muster", courseList3, courseList0);
	    Student student2 = new Student(48645, "Alice", "Klint", courseList4, courseList0);
	    Student student3 = new Student(24232, "Bob", "Ser", null, courseList1);

	    students.add(student0);
	    students.add(student1);
	    students.add(student2);
	    students.add(student3);
	}

	public String addStudentToCourse(int studentId, String courseId) throws MissingPrerequisiteException{
		Student student = students.get(studentId);
		Course course;
		course = new Course("c-1", "dummyCourse", "dummyDesc", null);

		// Check if as course with the given ID exists, otherwise leave a default course.
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(courseId)) {
				course = courses.get(i);
			}
		}

				// Only add course to the student if it exists.
				if(course.getId().equals("c-1")) {
					return "No course with this ID. No changes were made.";

				}
				else {
					if(!(course.getPrerequisite() == null)) {
						// Check if student has cleared all prerequisite courses.
						for (int i = 0; i < course.getPrerequisite().size(); i++) {

							if (!student.getCourses().contains(course.getPrerequisite().get(i))) {
								throw new MissingPrerequisiteException
										(course.getPrerequisite().get(i).getTitle(), course.getTitle());
							}
						}
					}
					student.getCourses().add(course);
					return "Student " + student.getFirstName() + " " + student.getLastName() + " added to curse " +
							course.getTitle() + ".";
				}
	}

	public StudentDto getStudent(int id) {
		StudentDto studentDto = new StudentDto();
		studentDto.setFirstName(students.get(id).getFirstName());
		studentDto.setLastName(students.get(id).getLastName());
		studentDto.setMatrNr(students.get(id).getMtrNumber());
		return studentDto;
	}

	public List<CourseDto> getCoursesFromStudent(int id) {

		List<Course> courses = students.get(id).getCourses();
		List<CourseDto> courseDtoList = new LinkedList<>();
		for ( Course c : courses) {
			CourseDto courseDto = new CourseDto();

			courseDto.setId(c.getId());
			courseDto.setTitle(c.getTitle());
			courseDto.setDescription(c.getDescription());

			courseDtoList.add(courseDto);
		}
		return courseDtoList;
	}

}