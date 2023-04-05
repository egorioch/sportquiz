package quiz.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import quiz.model.Person;
import quiz.repo.PersonRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8000")
public class PersonController {
    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/{id}")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Person getPerson(@PathVariable("id") long id) {
        return personRepo.getById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Person oldPerson, @RequestBody Person changePerson){
        BeanUtils.copyProperties(changePerson, oldPerson, "id");
        Person newPerson = personRepo.save(oldPerson);
        System.out.println("changed person: " + newPerson);

        return newPerson;
    }
}
