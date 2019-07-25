package pl.paprocka.apisurveysquizzes.quiz;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionForm {

    public QuizQuestionForm(Quiz quiz) {
        this.quiz = quiz;
        this.quizId = quiz.getId();
    }

    private Long quizId;
    private String questionText;
    private Quiz quiz;
}
