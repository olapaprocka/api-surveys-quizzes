package pl.paprocka.apisurveysquizzes.quiz;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class QuestionForm {

    private Quiz quiz;
    private List<EditQuizQuestion> questions;
    private Long quizId;
}
