package pl.paprocka.apisurveysquizzes.quiz;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quizName", length = 100)
    private String quizName;

    private LocalDate productionDate;

    @Column(name = "question", length = 150)
    private String question;
    @Column(name = "answer1", length = 150)
    private String answer1;
    @Column(name = "answer2", length = 150)
    private String answer2;
    @Column(name = "answer3", length = 150)
    private String answer3;
    @Column(name = "answer4", length = 150)
    private String answer4;


}
