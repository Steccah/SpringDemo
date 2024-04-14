package rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    // dictionary of people
    private final List<Person> people = new ArrayList<>();

    // add a person to the dictionary
    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        people.add(person);
    }

    // get all people in the dictionary
    @GetMapping("/people")
    public List<Person> getPeople() {
        return people;
    }

    // get a person by email
    @GetMapping("/person/{email}")
    public Person getPersonByEmail(@PathVariable String email) {
        for (Person person : people) {
            if (person.email().equals(email)) {
                return person;
            }
        }
        return null;
    }

    // delete a person by email
    @DeleteMapping("/person/{email}")
    public void deletePersonByEmail(@PathVariable String email) {
        people.removeIf(person -> person.email().equals(email));
    }

    // update a person by email
    @PutMapping("/person/{email}")
    public void updatePersonByEmail(@PathVariable String email, @RequestBody Person person) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).email().equals(email)) {
                people.set(i, person);
                return;
            }
        }
    }

    // get a person by name
    @GetMapping("/person/name/{name}")
    public List<Person> getPersonByName(@PathVariable String name) {
        List<Person> peopleByName = new ArrayList<>();
        for (Person person : people) {
            if (person.name().equals(name)) {
                peopleByName.add(person);
            }
        }
        return peopleByName;
    }

    // get a person by age
    @GetMapping("/person/age/{age}")
    public List<Person> getPersonByAge(@PathVariable int age) {
        List<Person> peopleByAge = new ArrayList<>();
        for (Person person : people) {
            if (person.age() == age) {
                peopleByAge.add(person);
            }
        }
        return peopleByAge;
    }

    // get a person by age range
    @GetMapping("/person/age/{minAge}/{maxAge}")
    public List<Person> getPersonByAgeRange(@PathVariable int minAge, @PathVariable int maxAge) {
        List<Person> peopleByAgeRange = new ArrayList<>();
        for (Person person : people) {
            if (person.age() >= minAge && person.age() <= maxAge) {
                peopleByAgeRange.add(person);
            }
        }
        return peopleByAgeRange;
    }

}
