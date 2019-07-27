package pl.paprocka.apisurveysquizzes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.paprocka.apisurveysquizzes.service.SurveyService;
import pl.paprocka.apisurveysquizzes.survey.*;
import pl.paprocka.apisurveysquizzes.user.PermissionService;
import pl.paprocka.apisurveysquizzes.user.User;
import pl.paprocka.apisurveysquizzes.user.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@Controller
public class SurveyController {

//
//    private SurveyService surveyService;
//
//    @Autowired
//    public SurveyController(SurveyService surveyService) {
//        this.surveyService = surveyService;
//    }
//
//    @Autowired
//    SurveyRepository surveyRepository;
//
//    @Autowired
//    PermissionService permissionService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    SurveyQuestionRepository surveyQuestionRepository;
//
//    @Autowired
//    SurveyAnswerRepository surveyAnswerRepository;
//
//    @GetMapping("/survey/surveys")
//    public String showSurveys(Model model) {
//        permissionService.getCurrentUserName();
//        Optional<User> user = userRepository.findByEmail(permissionService.getCurrentUserName());
//        List<Survey> surveys = surveyRepository.findByUser(user.get());
//        model.addAttribute("surveys", surveys);
//
//        return "/survey/showSurveys";
//    }
//
//    @GetMapping("/survey")
//    public String showSurveyForm(Model model) {
//        model.addAttribute("surveyForm", new SurveyForm());
//
//        return "/survey/surveyForm";
//    }
//
//    @GetMapping("/survey/surveyQuestion")
//    public String showSurveyQuestion(Model model) {
//        model.addAttribute("surveyQuestion", new SurveyQuestion());
//
//        return "/survey/surveyQuestion";
//    }
//
//
//
//    @PostMapping("/survey")
//    public String handleSurveyForm(@ModelAttribute @Valid SurveyForm surveyForm, Model model) {
//
//        Survey survey = surveyService.surveyForm(surveyForm);
//        SurveyQuestionForm surveyQuestion = new SurveyQuestionForm(survey);
//        model.addAttribute("surveyQuestion", surveyQuestion);
//
//        return "/survey/surveyQuestion";
//    }
//
//    @PostMapping("/survey/surveyQuestion")
//    public String handleSurveyQuestion(@ModelAttribute @Valid SurveyQuestionForm surveyQuestion, Model model) {
//
//        Survey survey = surveyService.addSurveyQuestion(surveyQuestion.getSurveyId(), surveyQuestion.getQuestionText());
//        SurveyQuestionForm surveyQuestionForm = new SurveyQuestionForm(survey);
//        model.addAttribute("surveyQuestion", surveyQuestionForm);
//
//        return "/survey/surveyQuestion";
//    }
//
//    @PostMapping("/survey/surveyAnswer")
//    public String handleSurveyAnswer(@ModelAttribute @Valid SurveyAnswerForm surveyAnswerForm, Model model) {
//        System.out.println(surveyAnswerForm);
//        SurveyQuestion surveyQuestion = surveyService.addSurveyQuestionAnswer(surveyAnswerForm.getQuestionId(), surveyAnswerForm.getAnswerText());
//        SurveyAnswerForm answerForm1 = new SurveyAnswerForm(surveyQuestion);
//        answerForm1.setQuestionId(surveyAnswerForm.getQuestionId());
//        model.addAttribute("surveyAnswer", surveyAnswerForm);
//        return "/survey/surveyAnswer";
//    }
//
//    @PutMapping
//    public String updateSurveyForm(@ModelAttribute @Valid SurveyForm surveyForm, Model model) {
//
//        Survey survey = surveyService.surveyForm(surveyForm);
//        SurveyQuestionForm surveyQuestion = new SurveyQuestionForm(survey);
//        model.addAttribute("surveyQuestion", surveyQuestion);
//
//        return "/survey/surveyQuestion";
//    }
//
//
//
//    @PutMapping("/survey/surveyQuestion")
//    public String updateSurveyQuestion(@ModelAttribute @Valid SurveyQuestionForm surveyQuestion, Model model) {
//
//        Survey survey = surveyService.addSurveyQuestion(surveyQuestion.getSurveyId(), surveyQuestion.getQuestionText());
//        SurveyQuestionForm surveyQuestionForm = new SurveyQuestionForm(survey);
//        model.addAttribute("surveyQuestion", surveyQuestionForm);
//
//        return "/survey/surveyQuestion";
//    }
//
//
//    @PutMapping("/survey/surveyAnswer")
//    public String updateSurveyAnswer(@ModelAttribute @Valid SurveyAnswerForm surveyAnswerForm, Model model) {
//        SurveyQuestion surveyQuestion = surveyService.addSurveyQuestionAnswer(surveyAnswerForm.getQuestionId(), surveyAnswerForm.getAnswerText());
//        SurveyAnswerForm answerForm1 = new SurveyAnswerForm(surveyQuestion);
//        answerForm1.setQuestionId(surveyAnswerForm.getQuestionId());
//        model.addAttribute("surveyAnswer", surveyAnswerForm);
//        return "/survey/surveyAnswer";
//    }
//
//
//
//    @DeleteMapping("/survey")
//    public void deleteSurveyForm(@ModelAttribute @Valid SurveyForm surveyForm, Model model) {
//
//        Survey survey = surveyService.surveyForm(surveyForm);
//        SurveyQuestionForm surveyQuestion = new SurveyQuestionForm(survey);
//        model.addAttribute("surveyQuestion", surveyQuestion);
//    }
//
//    @DeleteMapping("/survey/surveyQuestion")
//    public void deleteSurveyQuestion(@ModelAttribute @Valid SurveyQuestionForm surveyQuestion, Model model) {
//
//        Survey survey = surveyService.addSurveyQuestion(surveyQuestion.getSurveyId(), surveyQuestion.getQuestionText());
//        SurveyQuestionForm surveyQuestionForm = new SurveyQuestionForm(survey);
//        model.addAttribute("surveyQuestion", surveyQuestionForm);
//    }
//
//    @DeleteMapping("/survey/surveyAnswer")
//    public void deleteSurveyAnswer(@ModelAttribute @Valid SurveyAnswerForm surveyAnswerForm, Model model) {
//        SurveyQuestion surveyQuestion = surveyService.addSurveyQuestionAnswer(surveyAnswerForm.getQuestionId(), surveyAnswerForm.getAnswerText());
//        SurveyAnswerForm answerForm1 = new SurveyAnswerForm(surveyQuestion);
//        answerForm1.setQuestionId(surveyAnswerForm.getQuestionId());
//        model.addAttribute("surveyAnswer", surveyAnswerForm);
//    }
}

