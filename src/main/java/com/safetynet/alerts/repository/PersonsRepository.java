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

    @Override
    public List<Persons> getListPersons() {

        return database.getPersons();
    }
}