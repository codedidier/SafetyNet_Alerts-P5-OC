package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.service.FirestationsServiceInterface;

@RestController
public class FirestationsController {

    private static final Logger logger = LogManager.getLogger("FirestationsController");

    @Autowired
    private FirestationsServiceInterface firestationsServiceInterface;

    // Récupère la liste des firestations(address et station number)
    @GetMapping(value = "/firestations")
    public List<Firestations> getListFirestations() {

        List<Firestations> getFirestations = firestationsServiceInterface.getListFirestations();
        if (getFirestations != null) {
            logger.info("getFirestations GET demande rèussis");
        } else {
            logger.error("getFirestations GET demande FAILED");
        }
        return getFirestations;
    }

    // Ajouter une firestation
    @PostMapping(value = "/firestation")
    public List<Firestations> addFirestation(@RequestBody Firestations firestations) {

        List<Firestations> addFirestation = firestationsServiceInterface.addFirestationToList(firestations);
        if (addFirestation != null) {
            logger.info("addFirestation POST demande rèussis");
        } else {
            logger.error("addFirestation POST demande FAILED");
        }
        return addFirestation;
    }

    // mettre à jour une firestation
    @PutMapping(value = "/firestation")
    public Firestations updateFirestation(@RequestBody Firestations firestations) {

        Firestations updateFirestation = firestationsServiceInterface.updateFirestationToList(firestations);
        if (updateFirestation != null) {
            logger.info("updateFirestation PUT demande rèussis");
        } else {
            logger.error("updateFirestation PUT demande FAILED");
        }
        return updateFirestation;
    }

    // Supprimer une firestation
    @DeleteMapping(value = "/firestation/{address}")
    public void deleteFirestation(@PathVariable String address) {

        logger.info("deleteFirestation DELETE demande rèussis");
        firestationsServiceInterface.deleteFirestationToList(address);
    }
}
