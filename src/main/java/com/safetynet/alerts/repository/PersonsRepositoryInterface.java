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

//Recherche lastName pour les URLS
    List<Persons> getByLastName(String lastName);

//Recherche firstName and lastName pour les URLS
    List<Persons> getByFirstNameAndLastName(String firstName, String lastName);

//Recherche Address pour les URLS
    List<Persons> getByAddress(String address);

//Recherche Email par city pour les URLS
    List<Persons> getEmailByCity(String city);
}
