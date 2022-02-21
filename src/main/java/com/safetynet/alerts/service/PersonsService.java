package com.safetynet.alerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repositoryInterface.PersonsRepositoryInterface;
import com.safetynet.alerts.serviceInterface.PersonsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonsService implements PersonsServiceInterface {

    @Autowired
    PersonsRepositoryInterface personsRepositoryInterface;

    public PersonsService(PersonsRepositoryInterface personsRepositoryInterface) {

        this.personsRepositoryInterface = personsRepositoryInterface;
    }

//GET /persons
    @Override
    public List<Persons> getListPersons() {

        return personsRepositoryInterface.getListPersons();
    }

//POST /person
    @Override
    public List<Persons> addNewPersonToList(Persons persons) {

        log.info("Person added REUSSIS :" + persons);
        personsRepositoryInterface.addNewPersonToList(persons);
        return personsRepositoryInterface.getListPersons();
    }

//PUT /person
    @Override
    public Persons updatePersonToList(String firstNameAndLastName, Persons persons) {

        log.info("updatePersonToList REUSSIS :" + persons);
        return personsRepositoryInterface.updatePersonToList(firstNameAndLastName, persons);
    }

//DELETE //person
    @Override
    public List<Persons> deletePersonToList(String firstNameAndLastName) {

        log.info("deletePersonToList REUSSIS :" + firstNameAndLastName);
        personsRepositoryInterface.deletePersonToList(firstNameAndLastName);
        return personsRepositoryInterface.getListPersons();
    }

//URLS
    @Override
    public List<Persons> getByAddress(String address) {

        log.info("getByAddress REUSSIS :" + address);
        return personsRepositoryInterface.getByAddress(address);
    }

//URLS
    @Override
    public List<Persons> getByLastName(String lastName) {

        log.info("getByAddress REUSSIS :" + lastName);
        return personsRepositoryInterface.getByLastName(lastName);
    }

//URLS
    @Override
    public List<Persons> getByFirstNameAndLastName(String firstName, String lastName) {

        log.info("getByFirstNameAndLastName REUSSIS :" + (firstName + lastName));
        return personsRepositoryInterface.getByFirstNameAndLastName(firstName, lastName);
    }

//URLS
    @Override
    public List<Persons> getEmailByCity(String city) {

        log.info("getByEmailCity REUSSIS :" + city);
        return personsRepositoryInterface.getEmailByCity(city);
    }
}