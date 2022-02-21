package com.safetynet.alerts.serviceInterface;

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

//Recherche Address pour les URLS
    List<Persons> getByAddress(String address);

//Recherche LastName pour les URLS
    List<Persons> getByLastName(String lastName);

//Recherche FirstNameAndLastName pour les URLS
    List<Persons> getByFirstNameAndLastName(String firstName, String lastName);

//Recherche EmailByCity pour les URLS
    List<Persons> getEmailByCity(String city);
}