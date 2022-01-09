package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.service.PersonsServiceInterface;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class PersonsController {

    @Autowired
    PersonsServiceInterface personsServiceInterface;

    @GetMapping(value = "/persons")
    public List<Persons> getListPersons() {

        List<Persons> getPersons = personsServiceInterface.getListPersons();
        // if (getPersons != null) {
        // log.info("getListPersons GET request SUCCESS");
        // } else {
        // log.error("getListPersons GET request FAILED");
        // }

        return getPersons;
    }
}
