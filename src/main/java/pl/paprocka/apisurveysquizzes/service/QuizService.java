package pl.paprocka.apisurveysquizzes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.paprocka.apisurveysquizzes.quiz.*;



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

        return quizRepository.save(quiz);
    }


    @Transactional
    public QuizQuestion quizQuestion(QuizQuestion quizQuestion) {
        QuizQuestion questions = new QuizQuestion();
        quizQuestion.setQuestionText(quizQuestion.getQuestionText());
        return quizRepository.save(questions);
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
