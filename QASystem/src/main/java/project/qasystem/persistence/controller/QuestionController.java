package project.qasystem.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.service.*;
import project.qasystem.persistence.model.Question;

import java.util.List;


@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * Creates a question with the title, description and userName
     *
     * @param title The title of the question
     * @param description The content of the question
     * @param userName userName of the user.
     */
    public void createQuestionString (String title, String description, String userName) {
      questionService.insertQuestion(title, description, userName);
    }

    /**
     * handles get requests for questions.
     * checks if the provided id is valid and if the question exists.
     *
     * @param id the id of the question to be displayed
     * @param model the model Thymeleaf uses.
     * @return Question at success to display the found Question;
     * error when Question not found or id invalid.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //TODO adapt to new project
    public String getQuestion(@PathVariable("id") String id, Model model) {
        QuestionService service = new QuestionService();
        int idInt;
        try {
            idInt = Integer.parseInt(id);
        } catch (NumberFormatException excception) {
            model.addAttribute("error", "Das war keine gültige ID!");
            return "error";
        }
        Question toGet = service.getQuestionById(idInt);
        if (toGet == null) {
            model.addAttribute("error", "Übung nicht gefunden!");
            return "error";
        } else {
            model.addAttribute("Question", toGet);
            return "Question";
        }
    }

    @PostMapping(value = {"/searchQuestion"})
    public String getExistingQuestions(String name, Model model) {
        QuestionService service = new QuestionService();
        List<Question> toReturn = service.getQuestionListByName(name);
        model.addAttribute("listOfQuestions", toReturn);
        return "questionList";
    }

    /**
     * Handles Post-requests for questions.
     * Creates a new Question in the Database with the information provided by the user.
     *
     * @param question Question with data Thymeleaf provides.
     * @param model Model Thymeleaf uses.
     * @return redirects to the new webpage
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postQuestion(@ModelAttribute("Question") Question question, Model model) {
        QuestionService service = new QuestionService();
            service.insertQuestion(question.getTitle(), question.getDescription(),question.getUserName());
            //TODO add new webpage
            return "redirect:/home";
    }


     */

}
