package quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

}
