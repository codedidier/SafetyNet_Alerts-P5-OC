package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.service.PersonsServiceInterface;

@RestController
public class PersonsController {

    private static final Logger logger = LogManager.getLogger("PersonController");

    @Autowired
    PersonsServiceInterface personsServiceInterface;

    // Récupère la liste des persons (firstName, lastName, address, city, zip,
    // phone, email).
    @GetMapping(value = "/persons")
    public List<Persons> getListPersons() {

        List<Persons> getPersons = personsServiceInterface.getListPersons();
        if (getPersons != null) {
            logger.info("getListPersons GET request SUCCESS");
        } else {
            logger.error("getListPersons GET request FAILED");
        }

        return getPersons;
    }
}
