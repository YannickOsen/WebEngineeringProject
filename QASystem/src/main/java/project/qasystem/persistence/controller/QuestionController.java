package project.qasystem.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.DTOs.QuestionDto;
import project.qasystem.persistence.service.*;
import project.qasystem.persistence.model.Question;

import java.util.List;


@Controller
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

    @GetMapping("/newquestion")
    public String showQuestionForm(Model model) {
        model.addAttribute("newQuestion", new QuestionDto());
        return "newQuestion";
    }

    @PostMapping("/newquestion")
    public String newQuestion(@ModelAttribute("newQuestion") QuestionDto questionDto) {
        questionService.insertQuestion(questionDto.getTitle(), questionDto.getDescription(), questionDto.getUserName());
        return "redirect:/questionlist";
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
            return "welcome";
        }
        Question toGet = service.getQuestionById(idInt);
        if (toGet == null) {
            return "welcome";
        } else {
            model.addAttribute("thisQuestion", toGet);
            return "question";
        }
    }

    @GetMapping("/questionlist")
    public String getQuestions(Model model) {
        List<QuestionDto> toReturn = questionService.getAllQuestions();
        model.addAttribute("listOfQuestions", toReturn);
        return "questionList";
    }

    @GetMapping("/searchquestion")
    public String getQuestionsByCheckbox(@RequestParam("search") String value,
                                         @RequestParam(value = "solved", required = false) String solved,
                                         @RequestParam(value = "notsolved", required = false) String notsolved,
                                         @RequestParam(value = "answered", required = false) String answered,
                                         @RequestParam(value = "notanswered", required = false) String notanswered,
                                         @RequestParam(value = "myquestions", required = false) String myquestions, Model model) {
        List<QuestionDto> toReturn = null;
        if (value == "") {
            if (solved != null && notsolved != null && answered != null && notanswered != null && myquestions != null) {
                toReturn = questionService.getAllQuestions();
            }
            if (solved != null && notsolved == null && answered == null && notanswered == null && myquestions == null) {
                toReturn = questionService.getsolvedQuestions();
            }
            if (solved == null && notsolved != null && answered == null && notanswered == null && myquestions == null) {
                toReturn = questionService.getunsolvedQuestions();
            }
            if (solved == null && notsolved == null && answered != null && notanswered == null && myquestions == null) {
                toReturn = questionService.getansweredQuestions();
            }
            if (solved == null && notsolved == null && answered == null && notanswered != null && myquestions == null) {
                toReturn = questionService.getnotansweredQuestions();
            }
            if (solved != null && notsolved == null && answered != null && notanswered == null && myquestions != null) {
                toReturn = null;
            }
        } else {
            toReturn = questionService.getQuestionsByTitle(value);
        }

        model.addAttribute("listOfQuestions", toReturn);
        return "questionList";
    }
}
