package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Firestations;

@RestController
public class FirestationsController {

    @Autowired
    Database database;

    @GetMapping(value = "/firestations")
    public List<Firestations> getListFirestations() {

        return getListFirestations();
    }

}
