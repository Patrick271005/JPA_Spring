package ie.atu.jpa_spring;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person create(Person p) {

        return repo.save(p);
    }

    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public List<Person> findAll() { return repo.findAll(); }

    public Person updateByEmployeeID(String id, Person p) {
         repo.findByEmployeeId(p.getEmployeeId());
                return repo.save(p);
                //.orElseThrow(() -> new IllegalArgumentException("Person not found"));

    }


    public void deleteByEmployeeID(String id) {
        repo.deleteById(Long.valueOf(id));
    }

}

