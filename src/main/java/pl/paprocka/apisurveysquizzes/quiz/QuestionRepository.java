package pl.paprocka.apisurveysquizzes.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository <QuizQuestion, Long> {
    List<QuizAnswer> findAllById(Long answerId);


}
