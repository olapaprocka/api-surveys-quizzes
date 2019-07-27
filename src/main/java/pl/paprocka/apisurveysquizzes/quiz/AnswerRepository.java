package pl.paprocka.apisurveysquizzes.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AnswerRepository extends JpaRepository<QuizAnswer, Long> {
    Optional<QuizAnswer> findAllByUsername (String username);
}
