package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PersonDao {


    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> getAllPerson();

    Optional<Person> selectPersonById(UUID id);

    int deletePerson(UUID id);

    int updatePerson(UUID id,Person person);
}
