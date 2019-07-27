package pl.paprocka.apisurveysquizzes.quiz;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerForm {
    private Quiz quiz;
    private List<QuizAnswerForm> answers;
    private Long quizId;
}
