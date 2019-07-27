package pl.paprocka.apisurveysquizzes.service;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.paprocka.apisurveysquizzes.quiz.*;
import pl.paprocka.apisurveysquizzes.user.PermissionService;
import pl.paprocka.apisurveysquizzes.user.User;
import pl.paprocka.apisurveysquizzes.user.UserRepository;

import javax.persistence.Id;
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
        answer.setAnswerText(answerText);
        quizQuestion.getAnswers().add(answer);

        return questionRepository.saveAndFlush(quizQuestion);
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





    //        @Transactional
//        public Quiz editQuiz (String oldName, String newName){
//            editQuiz(oldName, newName);
//        }
//
//        private void editQuizName (String oldName, String newName){
//            Quiz quizName = quizRepository.findAllByQuizName(oldName).get();
//            quizName.setQuizName(newName);
//        }

//
////
//    @Transactional
//    public QuizAnswer quizAnswer(QuizAnswer quizAnswer) {
//        QuizAnswer answers = new QuizAnswer();
//        quizAnswer.setAnswerText(quizAnswer.getAnswerText());
//        return quizRepository.save(answers);
//    }

    //    public Optional<Quiz> findById(Long id) {
//        return quizRepository.findById(id);
//    }
//
//    public Iterable<Quiz> finAll() {
//        return quizRepository.findAll();
//    }
//
//
//    public Quiz save(Quiz quiz) {
//        return quizRepository.save(quiz);
//    }
//
//    public void deleteById(Long id) {
//        quizRepository.deleteById(id);
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        save(new Quiz(1L, "Quiz nr 1", LocalDate.of(2019, 01, 01), "Question 1", "Answer 1", "Answer 2", "Answer 3", "Answer 4"));
//        save(new Quiz(2L, "Quiz nr 2", LocalDate.of(2019, 07, 07), "Question 2", "Answer 1", "Answer 2", "Answer 4", "Answer 4"));
//    }


}
