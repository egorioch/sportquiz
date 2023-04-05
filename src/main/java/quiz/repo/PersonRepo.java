package quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
