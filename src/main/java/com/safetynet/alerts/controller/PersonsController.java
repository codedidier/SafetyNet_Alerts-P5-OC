package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.serviceInterface.PersonsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class PersonsController {

    @Autowired
    PersonsServiceInterface personsServiceInterface;

    // Récupère la liste persons (firstName, lastName, address, city, zip,
    // phone, email).
    @GetMapping(value = "/persons")
    public List<Persons> getListPersons() {

        List<Persons> getPersons = personsServiceInterface.getListPersons();
        if (getPersons != null) {
            log.info("getListPersons GET demande réussie");
        } else {
            log.error("getListPersons GET demande échouée");
        }

        return getPersons;
    }

    // Pour ajouter une personne
    @PostMapping(value = "/person")
    public List<Persons> addPersonList(@RequestBody Persons persons) {

        List<Persons> newPers = personsServiceInterface.addNewPersonToList(persons);
        if (newPers != null) {
            log.info("addPerson POST demande réussie");
        } else {
            log.error("addPerson POST demande échouée");
        }
        return newPers;
    }

    // pour mettre à jour une personne
    @PutMapping(value = "/person/{firstNameAndLastName}")
    public Persons updatePerson(@RequestBody Persons person, @PathVariable String firstNameAndLastName) {

        Persons personUpdate = personsServiceInterface.updatePersonToList(firstNameAndLastName, person);
        if (personUpdate != null) {
            log.info("updatePerson PUT demande réussie");
        } else {
            log.error("updatePerson PUT demande échouée");
        }
        return personUpdate;
    }

    // Pour supprimer une personne
    @DeleteMapping(value = "/person/{firstNameAndLastName}")
    public boolean deletePerson(@PathVariable String firstNameAndLastName) {

        log.info("deletePerson DELETE demande réussie");
        return personsServiceInterface.deletePersonToList(firstNameAndLastName);

    }
}
