package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Medicalrecords;

@RestController
public class MedicalrecordsController<MedicalrecordsServiceInterface> {

    private static final Logger logger = LogManager.getLogger("MedicalrecordsController");

    @Autowired
    MedicalrecordsServiceInterface medicalrecordsServiceInterface;

    // Récupère la liste des medicalRecords (firstName, lastName,birthdate,
    // medications, allergies).
    @GetMapping(value = "/medicalRecords")
    public List<Medicalrecords> getListMedicalrecords() {

        List<Medicalrecords> getMedicalrecords = medicalrecordsServiceInterface.getListMedicalrecords();
        if (getMedicalrecords != null) {
            logger.info("getListMedicalrecords GET request SUCCESS");
        } else {
            logger.error("getListMedicalRecords request GET is FAILED");
        }
        return getMedicalrecords;
    }

}
