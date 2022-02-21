package com.safetynet.alerts.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.serviceInterface.MedicalrecordsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class MedicalrecordsController {

    @Autowired
    MedicalrecordsServiceInterface medicalrecordsServiceInterface;

    // Récupère la liste des medicalRecords (firstName, lastName,birthdate,
    // medications, allergies).
    @GetMapping(value = "/medicalRecords")
    public List<Medicalrecords> getListMedicalrecords() {

        List<Medicalrecords> getMedicalrecords = medicalrecordsServiceInterface.getListMedicalrecords();
        if (getMedicalrecords != null) {
            log.info("getListMedicalrecords GET request SUCCESSFUL");
        } else {
            log.error("getListMedicalRecords request GET is FAILED");
        }
        return getMedicalrecords;
    }

    // Ajouter un dossier medical
    @PostMapping(value = "/medicalRecord")
    public List<Medicalrecords> addMedicalrecord(@RequestBody Medicalrecords medicalrecords) {

        List<Medicalrecords> newMedicalFile = medicalrecordsServiceInterface.addMedicalrecordToList(medicalrecords);
        if (newMedicalFile != null) {
            log.info("addMedicalrecord POST request SUCCESSFUL");
        } else {
            log.error("addMedicalrecord POST request FAILED");
        }
        return newMedicalFile;
    }

    // mettre a jour un dossier medical existant
    @PutMapping(value = "/medicalRecord/{firstNameAndLastName}")
    public Medicalrecords updateMedicalrecord(@RequestBody Medicalrecords medicalrecords,
            @PathVariable String firstNameAndLastName) throws ParseException {

        Medicalrecords updateMedical = medicalrecordsServiceInterface.updateMedicalrecordToList(firstNameAndLastName,
                medicalrecords);
        if (updateMedical != null) {
            log.info("updateMedicalrecord PUT request SUCCESSFUL");
        } else {
            log.error("updateMedicalrecord PUT request FAILED");
        }
        return updateMedical;
    }

    // Supprimer un dossier medical
    @DeleteMapping("/medicalRecord/{firstNameAndLastName}")
    public void deleteMedicalrecord(@PathVariable String firstNameAndLastName) {

        log.info("deleteMedicalrecord DELETE request SUCCESSFUL");
        medicalrecordsServiceInterface.deleteMedicalrecordToList(firstNameAndLastName);

    }

}
