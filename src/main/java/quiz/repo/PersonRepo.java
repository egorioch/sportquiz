package quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.model.Person;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
}
