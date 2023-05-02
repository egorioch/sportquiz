package quiz.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import quiz.model.Person;
import quiz.repo.PersonRepo;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final PersonRepo personRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(PersonRepo personRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepo = personRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Person loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Person> person = personRepo.findByName(name);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException(name);
        }

        return person.orElseThrow();
    }

    public boolean saveUser(Person person) {
        Optional<Person> personFromDb = personRepo.findByName(person.getName());

        if(personFromDb.isPresent()) {
            return false;
        }

        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personRepo.save(person);

        return true;
    }
}

