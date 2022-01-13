package com.safetynet.alerts.repository;

import java.text.ParseException;
import java.util.List;

import com.safetynet.alerts.model.Medicalrecords;

public interface MedicalrecordsRepositoryInterface {

//GET /medicalrecords
    List<Medicalrecords> getListMedicalrecords();

//POST /medicalRecord
    List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords);

    Medicalrecords addMedicalrecordToList(String firstNameAndLastName,
            Medicalrecords medicalrecords)
            throws ParseException;

}
