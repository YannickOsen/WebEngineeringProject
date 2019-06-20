package restapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

    @Test
    public void getStudentTest() throws Exception {
        // TODO Implement a test to retrieve data about a student
    }

    @Test
    public void registerForCourseTest() throws Exception {
        // TODO Implement a test to add a student to a course
    }

}
