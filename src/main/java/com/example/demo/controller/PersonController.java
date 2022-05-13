package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("addPerson")
    public int addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping("getAllPerson")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @PutMapping("updatePerson/{id}")
    public int updatePerson(@PathVariable("id") UUID id,@RequestBody Person person){
        return personService.updatePerson(id,person);
    }

    @GetMapping("getPersonById/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping("deletePerson/{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

}
