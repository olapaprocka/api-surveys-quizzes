package pl.paprocka.apisurveysquizzes.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paprocka.apisurveysquizzes.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Optional<Quiz> findAllByQuizName (String quizName);

    List<QuizQuestion> findAllById(String questionId);


    List<Quiz> findByUser(User user);
}
