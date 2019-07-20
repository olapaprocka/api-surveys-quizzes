package pl.paprocka.apisurveysquizzes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.paprocka.apisurveysquizzes.quiz.QuizForm;
import pl.paprocka.apisurveysquizzes.quiz.QuizRepository;
import pl.paprocka.apisurveysquizzes.service.QuizService;

import javax.validation.Valid;

@Controller
//@RestController
//@RequestMapping("/quizzes")
public class QuizController {


    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {

        this.quizService = quizService;
    }


    @Autowired
    QuizRepository quizRepository;

    @GetMapping("/quiz")
    public String showQuizForm(Model model) {
        model.addAttribute("quizForm", new QuizForm());

        return "quiz/quizForm";
    }


    @PostMapping("/quiz")
    public String handleQuizForm(@ModelAttribute @Valid QuizForm quizForm,
                                 Model model){

        quizService.quizForm(quizForm);

        return "/quiz";
    }
//    private QuizService quizzes;
//
//    @Autowired
//    public QuizController(QuizService quizzes) {
//        this.quizzes = quizzes;
//    }

//    @GetMapping("/all")
//    public Iterable<Quiz> getAll() {
//        return quizzes.finAll();
//    }
//
//    @GetMapping
//    public Optional<Quiz> getById(@RequestParam Long index) {
//        return quizzes.findById(index);
//    }
//
//
//    @PostMapping
//    public Quiz addQuiz(@RequestBody Quiz quiz) {
//        return quizzes.save(quiz);
//    }
//
//    @PutMapping
//    public Quiz updateQuiz(@RequestBody Quiz quiz) {
//        return quizzes.save(quiz);
//    }
//
//    @DeleteMapping
//    public void deleteQuiz(@RequestParam Long index) {
//         quizzes.deleteById(index);
//    }
//




}

