package pl.paprocka.apisurveysquizzes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.paprocka.apisurveysquizzes.quiz.Quiz;
import pl.paprocka.apisurveysquizzes.quiz.QuizForm;
import pl.paprocka.apisurveysquizzes.quiz.QuizRepository;

@Service
public class QuizService {


    private QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

@Transactional
    public Quiz quizForm(QuizForm quizForm) {


        Quiz quiz = new Quiz();
        quiz.setQuizName(quizForm.getQuizName());
//        quiz.setQuestion(quizForm.getQuestion());
//        quiz.setAnswer1(quizForm.getAnswer1());
//        quiz.setAnswer2(quizForm.getAnswer2());
//        quiz.setAnswer3(quizForm.getAnswer3());
//        quiz.setAnswer4(quizForm.getAnswer4());
return    quizRepository.save(quiz);


    }


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
