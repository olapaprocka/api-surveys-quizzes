package pl.paprocka.apisurveysquizzes.quiz;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EditQuizQuestion {


    public EditQuizQuestion(QuizQuestion quizQuestion) {
        this.questionId = quizQuestion.getId();
        this.questionText = quizQuestion.getQuestionText();
    }

    private Long questionId;
    private String questionText;

}
