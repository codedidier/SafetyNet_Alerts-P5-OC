package com.safetynet.alerts.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Persons;

import lombok.Data;

@Data
@Repository
public class PersonsRepository implements PersonsRepositoryInterface {

    private List<Persons> persons;

    @Autowired
    private Database database;

    public PersonsRepository() {
    }

//GET /persons
    @Override
    public List<Persons> getListPersons() {

        return database.getPersons();
    }

//POST /person
    @Override
    public List<Persons> addNewPersonToList(Persons persons) {
        List<Persons> addPersonList = database.getPersons();
        addPersonList.add(persons);
        return addPersonList;
    }

//TODO pourquoi l'annotation data ne fonctionne pas 
    public List<Persons> getPersons() {
        return persons;
    }

    public void setPersons(List<Persons> persons) {
        this.persons = persons;
    }
}