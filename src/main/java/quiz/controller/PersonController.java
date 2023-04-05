package quiz.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import quiz.model.Person;
import quiz.repo.PersonRepo;

@RestController
@RequestMapping("/login")
public class PersonController {
    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") long id) {
        return personRepo.getReferenceById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Person oldPerson, @RequestBody Person changePerson){
        BeanUtils.copyProperties(changePerson, oldPerson, "id");
        Person newPerson = personRepo.save(oldPerson);
        System.out.println("changed person: " + newPerson);

        return newPerson;
    }
}
