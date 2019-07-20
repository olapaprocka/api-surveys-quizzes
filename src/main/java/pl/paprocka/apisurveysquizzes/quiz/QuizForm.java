package pl.paprocka.apisurveysquizzes.quiz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class QuizForm {

    @NotNull(message = "Nazwa Quiz jest wymagana")
    private String quizName;


}