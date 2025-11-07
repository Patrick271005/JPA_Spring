package ie.atu.jpa_spring;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) { this.service = service; }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping
    public List<Person> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person byEmployeeId(@PathVariable String id) {
        return service.findByEmployeeId(id);
    }

    @PutMapping("/api/persons/{id}")
    public Person update(@PathVariable String id, @Valid @RequestBody Person person) {
        return service.updateByEmployeeID(id,person);


    }
    /*@DeleteMapping("/api/persons/{id}")
    public Person delete(@PathVariable String id) {
        return service.deleteByEmployeeID(id);
    }*/

    @DeleteMapping("/api/persons/{id}")
    public void delete(@PathVariable String id) {
        service.deleteByEmployeeID(id);
    }
}
