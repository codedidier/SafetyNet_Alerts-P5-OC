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

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.serviceInterface.FirestationsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class FirestationsController {

    @Autowired
    private FirestationsServiceInterface firestationsServiceInterface;

    // Récupère la liste des firestations(address et station number)
    @GetMapping(value = "/firestations")
    public List<Firestations> getListFirestations() {

        List<Firestations> getFirestations = firestationsServiceInterface.getListFirestations();
        if (getFirestations != null) {
            log.info("getFirestations GET demande rèussis");
        } else {
            log.error("getFirestations GET demande FAILED");
        }
        return getFirestations;
    }

    // Ajouter une firestation
    @PostMapping(value = "/firestation")
    public List<Firestations> addFirestation(@RequestBody Firestations firestations) {

        List<Firestations> addFirestation = firestationsServiceInterface.addFirestationToList(firestations);
        if (addFirestation != null) {
            log.info("addFirestation POST demande rèussis");
        } else {
            log.error("addFirestation POST demande FAILED");
        }
        return addFirestation;
    }

    // mettre à jour une firestation
    @PutMapping(value = "/firestation")
    public Firestations updateFirestation(@RequestBody Firestations firestations) {

        Firestations updateFirestation = firestationsServiceInterface.updateFirestationToList(firestations);
        if (updateFirestation != null) {
            log.info("updateFirestation PUT demande rèussis");
        } else {
            log.error("updateFirestation PUT demande FAILED");
        }
        return updateFirestation;
    }

    // Supprimer une firestation
    @DeleteMapping(value = "/firestation/{address}")
    public boolean deleteFirestation(@PathVariable String address) {

        log.info("deleteFirestation DELETE demande rèussis");
        return firestationsServiceInterface.deleteFirestationToList(address);
    }
}
