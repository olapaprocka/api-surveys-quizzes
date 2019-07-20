package pl.paprocka.apisurveysquizzes.quiz;

import javax.persistence.*;

@Entity
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "username")
    private String username;

}
