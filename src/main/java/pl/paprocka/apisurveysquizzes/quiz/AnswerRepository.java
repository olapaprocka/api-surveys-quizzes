package pl.paprocka.apisurveysquizzes.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paprocka.apisurveysquizzes.user.User;

import java.util.List;


@Repository
public interface AnswerRepository extends JpaRepository<QuizAnswer, Long> {
    List<QuizAnswer> findByUser (User user);

}
