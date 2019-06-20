package restapi;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "Empty call works ✨";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject returnStudent(@PathVariable int id) {
        JSONObject jo = new JSONObject();
        jo.put("Firstname", studentService.getStudent(id).getFirstName());
        jo.put("Lastname",studentService.getStudent(id).getLastName());
        jo.put("Matriculation Number", studentService.getStudent(id).getMatrNr());
        return jo;
    }

    @RequestMapping(value = "/students/{id}/courses", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject returnCourses(@PathVariable int id) {
        JSONObject jsonWrapper = new JSONObject();

        int count = 1;
        for (CourseDto course : studentService.getCoursesFromStudent(id)) {
            JSONObject jo = new JSONObject();
            jo.put("ID", course.getId());
            jo.put("Title", course.getTitle());
            jo.put("Description", course.getDescription());
            jsonWrapper.put("course " + count++, jo);
        }

        return jsonWrapper;
    }

    @RequestMapping(value = "/students/{id}/courses/{cid}", method = RequestMethod.POST)
    @ResponseBody
    public String returnCourses(@PathVariable int id, @PathVariable String cid) {
        return studentService.addStudentToCourse(id, cid);
    }
}
