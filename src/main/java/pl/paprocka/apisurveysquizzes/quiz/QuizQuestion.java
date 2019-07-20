package pl.paprocka.apisurveysquizzes.quiz;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

//    private Integer position;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Collection<QuizAnswer> answers;




}
