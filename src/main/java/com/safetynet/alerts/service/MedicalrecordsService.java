package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repository.MedicalrecordsRepositoryInterface;

@Service
public class MedicalrecordsService implements MedicalrecordsServiceInterface {

    private static final Logger logger = LogManager.getLogger("MedicalrecordsService");

    @Autowired
    MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface;

    @Autowired
    public MedicalrecordsService(MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface) {

        this.medicalrecordsRepositoryInterface = medicalrecordsRepositoryInterface;
    }

//GET /medicalrecords
    @Override
    public List<Medicalrecords> getListMedicalrecords() {

        logger.info("getListMedicalrecords SUCCESSFUL :");
        return medicalrecordsRepositoryInterface.getListMedicalrecords();
    }

//POST /medicalRecord
    @Override
    public List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords) {

        logger.info("addMedicalrecordToList SUCCESSFUL" + medicalrecords);
        return medicalrecordsRepositoryInterface.addMedicalrecordToList(medicalrecords);
    }

//PUT /medicalRecord

    @Override
    public Medicalrecords updateMedicalrecordToList(String firstNameAndLastName, Medicalrecords medicalrecords) {

        logger.info("updateMedicalrecordToList SUCCESS :" + medicalrecords);
        return medicalrecordsRepositoryInterface.updateMedicalrecordToList(firstNameAndLastName, medicalrecords);
    }

//DELETE /medicalRecord
    @Override
    public void deleteMedicalrecordToList(String firstNameAndLastName) {

        List<Medicalrecords> deleteMedical = medicalrecordsRepositoryInterface.getListMedicalrecords();
        deleteMedical.removeIf(medicalrecords -> medicalrecords.getFirstNameAndLastName().equals(firstNameAndLastName));
    }

//recherche par prenom et nom pour les URLS
    @Override
    public Medicalrecords getByFirstNameAndLastName(String firstName, String lastName) {

        logger.info("getByFirstNameAndLastName SUCCESS :" + (firstName + lastName));
        return medicalrecordsRepositoryInterface.getByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Medicalrecords getByFirstName(String firstName) {

        logger.info("getByLastName SUCCESS :" + firstName);
        return medicalrecordsRepositoryInterface.getByFirstName(firstName);

    }
}
