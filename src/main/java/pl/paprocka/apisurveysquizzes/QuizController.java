package pl.paprocka.apisurveysquizzes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.paprocka.apisurveysquizzes.quiz.*;
import pl.paprocka.apisurveysquizzes.service.QuizService;
import pl.paprocka.apisurveysquizzes.user.PermissionService;
import pl.paprocka.apisurveysquizzes.user.User;
import pl.paprocka.apisurveysquizzes.user.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class QuizController {


    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    PermissionService permissionService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("/quiz/quizzes")
    public String showQuizzes(Model model) {
        permissionService.getCurrentUserName();
        Optional<User> u = userRepository.findByEmail(permissionService.getCurrentUserName());
        List<Quiz> quizzes = quizRepository.findByUser(u.get());
        model.addAttribute("quizzes", quizzes);

        return "/quiz/showQuizzes";
    }

    @GetMapping("/quiz")
    public String showQuizForm(Model model) {
        model.addAttribute("quizForm", new QuizForm());

        return "/quiz/quizForm";
    }

    @GetMapping("/quiz/quizQuestion")
    public String showQuizQuestion(Model model) {
        model.addAttribute("quizQuestion", new QuizQuestion());

        return "/quiz/quizQuestion";
    }

    @GetMapping("/quiz/quizAnswer")
    public String showQuizAnswer(Model model) {
        model.addAttribute("quizAnswer", new QuizAnswer());

        return "/quiz/quizAnswer";
    }

    @PostMapping("/quiz")
    public String handleQuizForm(@ModelAttribute @Valid QuizForm quizForm, Model model) {

        Quiz q = quizService.quizForm(quizForm);
        QuizQuestionForm quizQuestion = new QuizQuestionForm(q);
        model.addAttribute("quizQuestion", quizQuestion);

        return "/quiz/quizQuestion";
    }

    @PostMapping("/quiz/quizQuestion")
    public String handleQuizQuestion(@ModelAttribute @Valid QuizQuestionForm quizQuestion, Model model) {

        Quiz q = quizService.addQuizQuestion(quizQuestion.getQuizId(), quizQuestion.getQuestionText());
        QuizQuestionForm form = new QuizQuestionForm(q);
        model.addAttribute("quizQuestion", form);

        return "/quiz/quizQuestion";
    }

    @PostMapping("/quiz/quizAnswer")
    public String handleQuizAnswer(@ModelAttribute @Valid QuizAnswerForm quizAnswerForm, Model model) {
        System.out.println(quizAnswerForm);
        QuizQuestion qq = quizService.addQuizQuestionAnswer(quizAnswerForm.getQuestionId(), quizAnswerForm.getAnswerText());
        QuizAnswerForm answerForm = new QuizAnswerForm(qq);
        answerForm.setQuestionId(quizAnswerForm.getQuestionId());
        model.addAttribute("quizAnswer", quizAnswerForm);
        return "/quiz/quizAnswer";
    }

    @PutMapping
    public String updateQuizForm(@ModelAttribute @Valid QuizForm quizForm, Model model) {

        Quiz q = quizService.quizForm(quizForm);
        QuizQuestionForm quizQuestion = new QuizQuestionForm(q);
        model.addAttribute("quizQuestion", quizQuestion);

        return "/quiz/quizQuestion";
    }



    @PutMapping("/quiz/quizQuestion")
    public String updateQuizQuestion(@ModelAttribute @Valid QuizQuestionForm quizQuestion, Model model) {

        Quiz q = quizService.addQuizQuestion(quizQuestion.getQuizId(), quizQuestion.getQuestionText());
        QuizQuestionForm form = new QuizQuestionForm(q);
        model.addAttribute("quizQuestion", form);

        return "/quiz/quizQuestion";
    }


    @PutMapping("/quiz/quizAnswer")
    public String updateQuizAnswer(@ModelAttribute @Valid QuizAnswerForm quizAnswerForm, Model model) {
        QuizQuestion qq = quizService.addQuizQuestionAnswer(quizAnswerForm.getQuestionId(), quizAnswerForm.getAnswerText());
        QuizAnswerForm answerForm = new QuizAnswerForm(qq);
        answerForm.setQuestionId(quizAnswerForm.getQuestionId());
        model.addAttribute("quizAnswer", quizAnswerForm);
        return "/quiz/quizAnswer";
    }



    @DeleteMapping("/quiz")
    public void deleteQuizForm(@ModelAttribute @Valid QuizForm quizForm, Model model) {

        Quiz q = quizService.quizForm(quizForm);
        QuizQuestionForm quizQuestion = new QuizQuestionForm(q);
        model.addAttribute("quizQuestion", quizQuestion);
    }

    @DeleteMapping("/quiz/quizQuestion")
    public void deleteQuizQuestion(@ModelAttribute @Valid QuizQuestionForm quizQuestion, Model model) {

        Quiz q = quizService.addQuizQuestion(quizQuestion.getQuizId(), quizQuestion.getQuestionText());
        QuizQuestionForm form = new QuizQuestionForm(q);
        model.addAttribute("quizQuestion", form);
    }

    @DeleteMapping("/quiz/quizAnswer")
    public void deleteQuizAnswer(@ModelAttribute @Valid QuizAnswerForm quizAnswerForm, Model model) {
        QuizQuestion qq = quizService.addQuizQuestionAnswer(quizAnswerForm.getQuestionId(), quizAnswerForm.getAnswerText());
        QuizAnswerForm answerForm = new QuizAnswerForm(qq);
        answerForm.setQuestionId(quizAnswerForm.getQuestionId());
        model.addAttribute("quizAnswer", quizAnswerForm);
    }
}

