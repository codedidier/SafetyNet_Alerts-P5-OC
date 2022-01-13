package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.service.PersonsServiceInterface;

@RestController
public class PersonsController {

    private static final Logger logger = LogManager.getLogger("PersonsController");

    @Autowired
    PersonsServiceInterface personsServiceInterface;

    // Récupère la liste persons (firstName, lastName, address, city, zip,
    // phone, email).
    @GetMapping(value = "/persons")
    public List<Persons> getListPersons() {

        List<Persons> getPersons = personsServiceInterface.getListPersons();
        if (getPersons != null) {
            logger.info("getListPersons GET demande réussie");
        } else {
            logger.error("getListPersons GET demande échouée");
        }

        return getPersons;
    }

    // Pour ajouter une personne
    @PostMapping(value = "/person")
    public List<Persons> addPersonList(@RequestBody Persons persons) {

        List<Persons> newPers = personsServiceInterface.addNewPersonToList(persons);
        if (newPers != null) {
            logger.info("addPerson POST demande réussie");
        } else {
            logger.error("addPerson POST demande échouée");
        }
        return newPers;
    }
}
