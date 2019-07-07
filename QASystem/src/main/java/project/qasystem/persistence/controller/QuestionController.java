package project.qasystem.persistence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.qasystem.persistence.Service.*;
import project.qasystem.persistence.Entities.*;


@Controller
@RequestMapping("/question")
public class QuestionController {



    /**
     * handles get requests for questions.
     * checks if the provided id is valid and if the question exists.
     *
     * @param id the id of the question to be displayed
     * @param model the model Thymeleaf uses.
     * @return exercise at success to display the found exercise;
     * error when exercise not found or id invalid.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //TODO adapt to new project
    public String getExercise(@PathVariable("id") String id, Model model) {
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
            model.addAttribute("exercise", toGet);
            return "exercise";
        }
    }


    /**
     * Handles Post-requests for questions.
     * Creates a new Question in the Database with the information provided by the user.
     *
     * @param question Question with data Thymeleaf provides.
     * @param model Model Thymeleaf uses.
     * @return redirects to the new webpage
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postExercise(@ModelAttribute("exercise") Question question, Model model) {
        QuestionService service = new QuestionService();
            service.insertQuestion(question.getTitle(), question.getDescription(),question.getUserName());
            //TODO add new webpage
            return "redirect:/home";
    }



}
