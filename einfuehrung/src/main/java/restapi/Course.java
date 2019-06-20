package restapi;

import java.util.List;

public class Course {

	private final String id;
	private final String title;
	private final String description;
	private final List<Course> prerequisite;


	public Course(String id, String title, String description, List<Course> prerequisite) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.prerequisite = prerequisite;

	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public List<Course> getPrerequisite() { return prerequisite; }
}