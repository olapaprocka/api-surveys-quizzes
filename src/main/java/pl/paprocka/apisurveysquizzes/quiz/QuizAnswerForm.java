package pl.paprocka.apisurveysquizzes.quiz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QuizAnswerForm {


    public QuizAnswerForm(QuizQuestion quizQuestion) {
        this.quizQuestion = quizQuestion;
        this.questionId = quizQuestion.getId();
    }


    private Long questionId;
    private String answerText;
    private QuizQuestion quizQuestion;
}
