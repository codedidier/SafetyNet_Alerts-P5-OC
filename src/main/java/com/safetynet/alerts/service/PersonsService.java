package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.PersonsRepositoryInterface;

@Service
public class PersonsService implements PersonsServiceInterface {

    private static final Logger logger = LogManager.getLogger("PersonsService");

    @Autowired
    PersonsRepositoryInterface personsRepositoryInterface;

    public PersonsService(PersonsRepositoryInterface personsRepositoryInterface) {

        this.personsRepositoryInterface = personsRepositoryInterface;
    }

    @Override
    public List<Persons> getListPersons() {

        return personsRepositoryInterface.getListPersons();
    }

    @Override
    public List<Persons> addNewPersonToList(Persons persons) {

        logger.info("Person added SUCCESS :" + persons);
        personsRepositoryInterface.addNewPersonToList(persons);
        return personsRepositoryInterface.getListPersons();
    }
}