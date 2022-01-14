package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.Persons;

public interface PersonsServiceInterface {

    // GET /persons
    List<Persons> getListPersons();

//POST /person
    List<Persons> addNewPersonToList(Persons persons);

//UPDATE /person
    Persons updatePersonToList(String firstNameAndLastName, Persons persons);

//DELETE /person
    List<Persons> deletePersonToList(String firstNameAndLastName);
}
