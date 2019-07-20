package pl.paprocka.apisurveysquizzes.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Optional<Quiz> findAllByQuizName (String quizName);
    Optional<Quiz> findAllByQuestions(String question);

}
