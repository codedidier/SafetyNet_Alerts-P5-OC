package com.safetynet.alerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.PersonsRepositoryInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonsService implements PersonsServiceInterface {

    @Autowired
    PersonsRepositoryInterface personsRepositoryInterface;

    public PersonsService(PersonsRepositoryInterface personsRepositoryInterface) {

        this.personsRepositoryInterface = personsRepositoryInterface;
    }

    @Override
    public List<Persons> getListPersons() {

        return personsRepositoryInterface.getListPersons();
    }
}