package rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    //dictionary of people
    private final List<Person> people = new ArrayList<>();

    //add a person to the dictionary
    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        people.add(person);
    }

    //get all people in the dictionary
    @GetMapping("/people")
    public List<Person> getPeople() {
        return people;
    }

    //get a person by email
    @GetMapping("/person")
    public Person getPersonByEmail(@RequestParam String email) {
        for (Person person : people) {
            if (person.email().equals(email)) {
                return person;
            }
        }
        return null;
    }
}
