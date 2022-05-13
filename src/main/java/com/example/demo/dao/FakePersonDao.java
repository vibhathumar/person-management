package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDao implements PersonDao{

    private final List<Person> db=new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPerson() {
        return db;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isEmpty()){
           return 0;
        }else {
            db.removeIf(person -> person.getId().equals(id));
            return 1;
        }
    }

    @Override
    public int updatePerson(UUID id,Person person) {

        db.removeIf(person1 -> person1.getId().equals(id));
        db.add(new Person(id, person.getName()));
        return 1;
    }
}
