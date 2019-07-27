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
        this.questionText = quizQuestion.getQuestionText();
        this.questionId = quizQuestion.getId();
    }

    private Long questionId;
    private String answerText;
    private String questionText;
}
