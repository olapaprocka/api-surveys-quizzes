package pl.paprocka.apisurveysquizzes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.paprocka.apisurveysquizzes.survey.*;
import pl.paprocka.apisurveysquizzes.user.PermissionService;
import pl.paprocka.apisurveysquizzes.user.User;
import pl.paprocka.apisurveysquizzes.user.UserRepository;

import java.util.Optional;


//@Service
public class SurveyService {
//
//
//    private SurveyRepository surveyRepository;
//
//    private SurveyQuestionRepository surveyQuestionRepository;
//
//    private PermissionService permissionService;
//
//    private UserRepository userRepository;
//
//    private SurveyAnswerRepository surveyAnswerRepository;
//
//    @Autowired
//    public SurveyService(SurveyRepository surveyRepository, SurveyQuestionRepository surveyQuestionRepository,
//                         PermissionService permissionService, UserRepository userRepository,
//                         SurveyAnswerRepository surveyAnswerRepository) {
//        this.surveyRepository = surveyRepository;
//        this.surveyQuestionRepository = surveyQuestionRepository;
//        this.permissionService = permissionService;
//        this.userRepository = userRepository;
//        this.surveyAnswerRepository = surveyAnswerRepository;
//    }
//
//
//
//
//    @Transactional
//    public Survey surveyForm(SurveyForm surveyForm) {
//        Survey survey = new Survey();
//        permissionService.getCurrentUserName();
//        Optional<User> u = userRepository.findByEmail(permissionService.getCurrentUserName());
//        survey.setSurveyName(surveyForm.getSurveyName());
//        survey.setUser(u.get());
//
//        return surveyRepository.save(survey);
//    }
//
//    @Transactional
//    public Survey addSurveyQuestion(Long surveyId, String questionText) {
//        Survey survey= surveyRepository.findById(surveyId).get();
//        SurveyQuestion surveyQuestion = new SurveyQuestion();
//        surveyQuestion.setQuestionText(questionText);
//        survey.getQuestions().add(surveyQuestion);
//        return surveyRepository.saveAndFlush(survey);
////        return surveyQuestion;
//    }
//
//
//    @Transactional
//    public SurveyQuestion addSurveyQuestionAnswer(Long questionId, String answerText) {
//        SurveyQuestion surveyQuestion = surveyQuestionRepository.findById(questionId).get();
//        SurveyAnswer surveyAnswer = new SurveyAnswer();
//        surveyAnswer.setAnswerText(answerText);
//        surveyQuestion.getAnswers().add(surveyAnswer);
//
//        return surveyQuestionRepository.saveAndFlush(surveyQuestion);
//    }

}
