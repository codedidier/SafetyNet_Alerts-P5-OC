package com.safetynet.alerts.repository;

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
}
