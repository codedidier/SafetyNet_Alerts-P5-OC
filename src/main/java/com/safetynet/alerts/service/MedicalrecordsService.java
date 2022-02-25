package com.safetynet.alerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repositoryInterface.MedicalrecordsRepositoryInterface;
import com.safetynet.alerts.serviceInterface.MedicalrecordsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MedicalrecordsService implements MedicalrecordsServiceInterface {

    @Autowired
    MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface;

    @Autowired
    public MedicalrecordsService(MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface) {

        this.medicalrecordsRepositoryInterface = medicalrecordsRepositoryInterface;
    }

//GET /medicalrecords
    @Override
    public List<Medicalrecords> getListMedicalrecords() {

        log.info("getListMedicalrecords SUCCESSFUL :");
        return medicalrecordsRepositoryInterface.getListMedicalrecords();
    }

//POST /medicalRecord
    @Override
    public List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords) {

        log.info("addMedicalrecordToList SUCCESSFUL" + medicalrecords);
        return medicalrecordsRepositoryInterface.addMedicalrecordToList(medicalrecords);
    }

//PUT /medicalRecord

    @Override
    public Medicalrecords updateMedicalrecordToList(String firstNameAndLastName, Medicalrecords medicalrecords) {

        log.info("updateMedicalrecordToList SUCCESS :" + medicalrecords);
        return medicalrecordsRepositoryInterface.updateMedicalrecordToList(firstNameAndLastName, medicalrecords);
    }

//DELETE /medicalRecord
    @Override
    public boolean deleteMedicalrecordToList(String firstNameAndLastName) {
        try {
            List<Medicalrecords> deleteMedical = medicalrecordsRepositoryInterface.getListMedicalrecords();
            return deleteMedical
                    .removeIf(medicalrecords -> medicalrecords.getFirstNameAndLastName().equals(firstNameAndLastName));

        } catch (Exception exception) {
            log.error("deletePersonToList ERROR :" + exception.getMessage());
        }
        log.info("deletePersonToList SUCCESS :" + firstNameAndLastName);
        return medicalrecordsRepositoryInterface.getListMedicalrecords() != null;
    }

//recherche par prenom et nom pour les URLS
    @Override
    public Medicalrecords getByFirstNameAndLastName(String firstName, String lastName) {

        log.info("getByFirstNameAndLastName SUCCESS :" + (firstName + lastName));
        return medicalrecordsRepositoryInterface.getByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Medicalrecords getByFirstName(String firstName) {

        log.info("getByLastName SUCCESS :" + firstName);
        return medicalrecordsRepositoryInterface.getByFirstName(firstName);

    }
}
