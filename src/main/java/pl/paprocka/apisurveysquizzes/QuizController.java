package pl.paprocka.apisurveysquizzes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.paprocka.apisurveysquizzes.quiz.Quiz;
import pl.paprocka.apisurveysquizzes.quiz.QuizForm;
import pl.paprocka.apisurveysquizzes.quiz.QuizQuestion;
import pl.paprocka.apisurveysquizzes.quiz.QuizRepository;
import pl.paprocka.apisurveysquizzes.service.QuizService;
import pl.paprocka.apisurveysquizzes.user.User;

import javax.validation.Valid;
import java.util.List;

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


    @GetMapping("/quizzes")
    public String showQuizzes(Model model) {
        List<Quiz> quizzes = quizRepository.findAll();
        model.addAttribute("quizzes", quizzes);
        return "quiz/showQuizzes";
    }

    @GetMapping("/quiz")
    public String showQuizForm(Model model) {
        model.addAttribute("quizForm", new QuizForm());

        return "quiz/quizForm";
    }


    @PostMapping("/quiz")
    public String handleQuizForm(@ModelAttribute @Valid QuizForm quizForm,
                                 Model model){

        quizService.quizForm(quizForm);
        model.addAttribute("quizQuestion", new QuizQuestion());
        return "/quiz/quizQuestion";
    }
//
//    @PostMapping("/quizQuestion")
//    public String handleQuizQuestion(@ModelAttribute @Valid QuizQuestion quizQuestion,
//                                 Model model){
//
//        quizService.quizQuestion(quizQuestion);
//
//        return "/quiz/quizQuestion";
//    }
//


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

