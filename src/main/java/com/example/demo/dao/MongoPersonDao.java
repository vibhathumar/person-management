package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mongoDao1")
public class MongoPersonDao  implements PersonDao{
    
    private final List<Person> personMongoDb;


    @Autowired
    public MongoPersonDao(List<Person> personMongoDb) {
        this.personMongoDb = personMongoDb;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        personMongoDb.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPerson() {
        personMongoDb.add(new Person(UUID.randomUUID(),"Vira"));
        return personMongoDb;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePerson(UUID id) {
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return 0;
    }
}
