package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.Medicalrecords;

public interface MedicalrecordsServiceInterface {

//GET /medicalrecords
    List<Medicalrecords> getListMedicalrecords();

//POST /medicalRecord
    List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords);

//PUT /medicalRecord
    Medicalrecords updateMedicalrecordToList(String firstNameAndLastName, Medicalrecords medicalrecords);

//delete medicalRecord    
    void deleteMedicalrecordToList(String firstNameAndLastName);
}
