package pl.paprocka.apisurveysquizzes.quiz;


import lombok.*;
import pl.paprocka.apisurveysquizzes.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    private User user;

    private LocalDate productionDate;

    @OneToMany(cascade = CascadeType.ALL)//robi za repository
//    @OrderBy("position")
    @JoinColumn(name = "quiz_id")
    private List<QuizQuestion> questions;

}
