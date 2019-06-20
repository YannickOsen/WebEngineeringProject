package restapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingPrerequisiteException extends RuntimeException {

    public MissingPrerequisiteException(String missingCourse, String targetCourse) {
        super("Student needs to finish: " + missingCourse + " to attend " + targetCourse + "!");
    }
}
