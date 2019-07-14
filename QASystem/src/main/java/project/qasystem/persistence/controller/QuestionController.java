package project.qasystem.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.DTOs.AnswerDTO;
import project.qasystem.persistence.DTOs.QuestionDto;
import project.qasystem.persistence.model.Answer;
import project.qasystem.persistence.service.*;
import project.qasystem.persistence.model.Question;

import javax.validation.constraints.Null;
import java.security.Principal;
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
    public String showQuestionForm(Model model, Principal principal) {
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        model.addAttribute("newQuestion", new QuestionDto());
        return "newQuestion";
    }

    @PostMapping("/newquestion")
    public String newQuestion(@ModelAttribute("newQuestion") QuestionDto questionDto, Principal principal) {
        questionDto.setUserName(principal.getName());
        questionService.insertQuestion(questionDto.getTitle(), questionDto.getDescription(), questionDto.getUserName());
        return "redirect:/questionlist";
    }

    @GetMapping("/answerquestion/{id}")
    public String showAnswerForm(@PathVariable("id") String id, Model model, Principal principal) {
        List<QuestionDto> questionsOfThisUser = null;
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
            questionsOfThisUser = questionService.getuserQuestions(principal.getName());
        }
        model.addAttribute("answer", new AnswerDTO());
        int idInt;
        try {
            idInt = Integer.parseInt(id);
        } catch (NumberFormatException exception) {
            return "welcome";
        }
        Question toGet = questionService.getQuestionById(idInt);
        List<AnswerDTO> answersToGet = questionService.getAnswerByQuestion(toGet);
        if (toGet == null) {
            return "welcome";
        } else {
            model.addAttribute("thisQuestion", toGet);
            model.addAttribute("thisAnswerInList", answersToGet);
            model.addAttribute("listOfQuestions", questionsOfThisUser);
            return "question";
        }
    }

    @PostMapping("/answerquestion/{id}")
    public String answerQuestion(
            @PathVariable("id") String id,
            @ModelAttribute("answer") AnswerDTO answerDTO,
            Principal principal) {
        answerDTO.setAuthorName(principal.getName());
        answerDTO.setIdQuestion(Long.parseLong(id));
        questionService.insertAnswer(answerDTO.getAuthorName(), answerDTO.getIdQuestion(), answerDTO.getText());
        return "redirect:/answerquestion/{id}";
    }

    @PostMapping("/answerquestion/{id}/setbookmark")
    public String moveToBookmarks(@PathVariable("id") String id, Principal principal) {
        questionService.saveBookmarkedQuestion(id, principal.getName());
        return "redirect:/questionlist";
    }


    @GetMapping("/questionSolved/{id}/{idAnswer}")
    public String markAsSolved(@PathVariable("id") String idQuestion, @PathVariable("idAnswer") String idAnswer, Principal principal, Model model) {
        int idIntAnswer;
        int idIntQuestion;
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        try {
            idIntAnswer = Integer.parseInt(idAnswer);
            idIntQuestion = Integer.parseInt(idQuestion);
        } catch (NumberFormatException exception) {
            return "welcome";
        }
        questionService.questionSolved(idIntAnswer);
        //long questionId = questionService.getAnswerById(idIntAnswer).getQuestion().getId();
        return "redirect:/answerquestion/{id}";
    }

    @GetMapping("/questionlist")
    public String getQuestions(Model model, Principal principal) {
        List<QuestionDto> toReturn = questionService.getAllQuestions();
        model.addAttribute("listOfQuestions", toReturn);
        if (principal != null){
            String userID = principal.getName();
            List<QuestionDto> bookMarks = questionService.getBookmarkedQuestions(userID);
            model.addAttribute("bookMarkQuestion", bookMarks);
        }
        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
        return "questionList";
    }

    @GetMapping("/searchquestion")
    public String getQuestionsByCheckbox(
                                         @RequestParam("search") String value,
                                         @RequestParam(value = "solved", required = false) String solved,
                                         @RequestParam(value = "notsolved", required = false) String notsolved,
                                         @RequestParam(value = "answered", required = false) String answered,
                                         @RequestParam(value = "notanswered", required = false) String notanswered,
                                         @RequestParam(value = "myquestions", required = false) String myquestions,
                                         Model model, Principal principal
    ) {

        if (principal != null){
            Boolean isLoggedIn = true;
            model.addAttribute("isLoggedIn", isLoggedIn);
        }
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
            if (solved == null && notsolved == null && answered == null && notanswered == null && myquestions != null) {
                toReturn = questionService.getuserQuestions(principal.getName());
            }
        } else {
            toReturn = questionService.getQuestionsByTitle(value);
        }

        model.addAttribute("listOfQuestions", toReturn);
        return "questionList";
    }
}
