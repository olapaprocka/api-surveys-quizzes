package pl.paprocka.apisurveysquizzes;


import lombok.extern.slf4j.Slf4j;
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
import java.util.stream.Collectors;

@Slf4j
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

    @GetMapping("/quiz/edit")
    public String goToQuizEdit(@RequestParam Long id, Model model) {
        log.info("Prepare the quiz for edit with id={}", id);
        // todo prepare model
        Quiz quiz = quizRepository.findById(id).get();
        List<EditQuizQuestion> questions = quiz.getQuestions()
                .stream()
                .map(EditQuizQuestion::new)
                .collect(Collectors.toList());

     model.addAttribute("quiz", new QuestionForm(quiz, questions, quiz.getId()));

        return "/quiz/editQuiz";
    }



    @PostMapping("/quiz/edit")
    public String handleQuizEdit(@ModelAttribute (name = "quiz") @Valid QuestionForm editQuizQuestion, Model model) {
        quizService.addEditQuizQuestion(editQuizQuestion);
        log.info("{}", editQuizQuestion);
        return "redirect:/quiz/quizzes";
    }



    @GetMapping("/quiz/answer")
    public String goToQuizAnswer(@RequestParam Long id, Model model) {
        log.info("Prepare the quiz for answer questions with id={}", id);
        Quiz quiz = quizRepository.findById(id).get();
//        model.addAttribute("quiz", quiz);
        List<QuizAnswerForm> answers = quiz.getQuestions()
                .stream()
                .map(QuizAnswerForm::new)
                .collect(Collectors.toList());
        model.addAttribute("answer", new AnswerForm(quiz, answers, quiz.getId()));
        return "/quiz/quizAnswer";
    }

    @PostMapping("/quiz/quizAnswer")
    public String handleQuizAnswer(@ModelAttribute("answer") @Valid AnswerForm answer, Model model) {
        System.out.println(answer);
        //
//        System.out.println(quizAnswerForm);
//        QuizQuestion qq = quizService.addQuizQuestionAnswer(quizAnswerForm.getQuestionId(), quizAnswerForm.getAnswerText());
//        QuizAnswerForm answerForm = new QuizAnswerForm(qq);
//        answerForm.setQuestionId(quizAnswerForm.getQuestionId());
//        model.addAttribute("quizAnswer", quizAnswerForm);
        return "redirect:/quiz/quizzes";
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

