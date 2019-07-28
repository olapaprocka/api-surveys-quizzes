package pl.paprocka.apisurveysquizzes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.paprocka.apisurveysquizzes.quiz.*;
import pl.paprocka.apisurveysquizzes.user.PermissionService;
import pl.paprocka.apisurveysquizzes.user.User;
import pl.paprocka.apisurveysquizzes.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class QuizService {


    private QuizRepository quizRepository;

    private QuestionRepository questionRepository;

    private PermissionService permissionService;

    private UserRepository userRepository;

    private AnswerRepository answerRepository;


    @Autowired
    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository,
                       PermissionService permissionService, UserRepository userRepository,
                       AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.permissionService = permissionService;
        this.userRepository = userRepository;
        this.answerRepository = answerRepository;
    }
    public List<QuizQuestion> showQuiz(Long id)
    {
        Quiz quiz =  quizRepository.findById(id).get();
       return  quiz.getQuestions();

    }

    public List<String> findAnswers(QuizQuestion quizQuestion )
    {
       return quizQuestion.getAnswers().stream().map(QuizAnswer::getAnswerText).collect(Collectors.toList());
    }


    @Transactional
    public QuizQuestion addQuizQuestionAnswer(Long questionId, String answerText) {
        QuizQuestion quizQuestion = questionRepository.findById(questionId).get();
        QuizAnswer answer = new QuizAnswer();
        permissionService.getCurrentUserName();
        Optional<User> user = userRepository.findByEmail(permissionService.getCurrentUserName());
        answer.setAnswerText(answerText);
        answer.setUser(user.get());
        quizQuestion.getAnswers().add(answer);



        return questionRepository.save(quizQuestion);
    }

    @Transactional
    public void addEditQuizQuestion(QuestionForm questionForm) {
        questionForm.getQuestions().forEach(q -> {
            QuizQuestion question = questionRepository.findById(q.getQuestionId()).get();
            question.setQuestionText(q.getQuestionText());
        });
    }

    @Transactional
    public Quiz quizForm(QuizForm quizForm) {
        Quiz quiz = new Quiz();
        permissionService.getCurrentUserName();
        Optional<User> u = userRepository.findByEmail(permissionService.getCurrentUserName());
        quiz.setQuizName(quizForm.getQuizName());
        quiz.setUser(u.get());

        return quizRepository.save(quiz);
    }

    @Transactional
    public Quiz addQuizQuestion(Long quizId, String questionText) {
        Quiz quiz = quizRepository.findById(quizId).get();
        QuizQuestion question = new QuizQuestion();
        question.setQuestionText(questionText);
        quiz.getQuestions().add(question);
        return quizRepository.saveAndFlush(quiz);
//        return question;
    }

    @Transactional
    public void addQuizAnswers(AnswerForm answer) {
        answer.getAnswers().forEach(a -> {
            QuizQuestion quizQuestion = questionRepository.findById(a.getQuestionId()).get();
            QuizAnswer quizAnswer = new QuizAnswer();
            quizAnswer.setAnswerText(a.getAnswerText());
            quizQuestion.getAnswers().add(quizAnswer);
            questionRepository.save(quizQuestion);
        });
    }

}
