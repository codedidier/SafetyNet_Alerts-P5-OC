package com.safetynet.alerts.repository;

import java.util.List;

import com.safetynet.alerts.model.Persons;

public interface PersonsRepositoryInterface {

//GET /persons
    List<Persons> getListPersons();

//POST /person
    List<Persons> addNewPersonToList(Persons persons);

//UPDATE /person
    Persons updatePersonToList(String firstNameAndLastName, Persons persons);

//DELETE /person
    void deletePersonToList(String firstNameAndLastName);

}
