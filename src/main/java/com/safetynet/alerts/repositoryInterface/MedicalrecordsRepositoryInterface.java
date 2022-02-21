package com.safetynet.alerts.repositoryInterface;

import java.util.List;

import com.safetynet.alerts.model.Medicalrecords;

public interface MedicalrecordsRepositoryInterface {

//GET /medicalrecords
    List<Medicalrecords> getListMedicalrecords();

//POST /medicalRecord
    List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords);

//PUT /medicalRecord
    Medicalrecords updateMedicalrecordToList(String firstNameAndLastName, Medicalrecords medicalrecords);

//DELETE medicalRecord
    void deleteMedicalrecordToList(String firstNameAndLastName);

//Recherche par prènom et nom pour les URLS
    Medicalrecords getByFirstNameAndLastName(String firstName, String lastName);

    Medicalrecords getByFirstName(String firstName);
}
