package pl.paprocka.apisurveysquizzes.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<QuizAnswer, Long> {
}
