package pl.paprocka.apisurveysquizzes.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.paprocka.apisurveysquizzes.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answer_text")
    private String answerText;
//
//    @Column(name = "username")
//    private String username;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "QuizAnswer{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
