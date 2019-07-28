package pl.paprocka.apisurveysquizzes.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Collection<QuizAnswer> answers;

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
