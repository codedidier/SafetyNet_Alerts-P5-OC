package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.PersonsRepositoryInterface;

import lombok.Data;

@Data
@Service
public class PersonsService implements PersonsServiceInterface {

    private static final Logger logger = LogManager.getLogger("PersonsService");

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

        logger.info("Person added REUSSIS :" + persons);
        personsRepositoryInterface.addNewPersonToList(persons);
        return personsRepositoryInterface.getListPersons();
    }

//UPDATE /person
    @Override
    public Persons updatePersonToList(String firstNameAndLastName, Persons persons) {

        logger.info("updatePersonToList REUSSIS :" + persons);
        return personsRepositoryInterface.updatePersonToList(firstNameAndLastName, persons);
    }

//DELETE //person
    @Override
    public List<Persons> deletePersonToList(String firstNameAndLastName) {

        logger.info("deletePersonToList REUSSIS :" + firstNameAndLastName);
        personsRepositoryInterface.deletePersonToList(firstNameAndLastName);
        return personsRepositoryInterface.getListPersons();
    }

//URLS
    @Override
    public List<Persons> getByAddress(String address) {

        logger.info("getByAddress REUSSIS :" + address);
        return personsRepositoryInterface.getByAddress(address);
    }

//URLS
    @Override
    public List<Persons> getByLastName(String lastName) {

        logger.info("getByAddress REUSSIS :" + lastName);
        return personsRepositoryInterface.getByLastName(lastName);
    }

//URLS
    @Override
    public List<Persons> getByFirstNameAndLastName(String firstName, String lastName) {

        logger.info("getByFirstNameAndLastName REUSSIS :" + (firstName + lastName));
        return personsRepositoryInterface.getByFirstNameAndLastName(firstName, lastName);
    }

//URLS
    @Override
    public List<Persons> getEmailByCity(String city) {

        logger.info("getByEmailCity REUSSIS :" + city);
        return personsRepositoryInterface.getEmailByCity(city);
    }
}