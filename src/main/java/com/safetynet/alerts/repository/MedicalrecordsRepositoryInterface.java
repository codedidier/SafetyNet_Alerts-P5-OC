package com.safetynet.alerts.repository;

import java.text.ParseException;
import java.util.List;

import com.safetynet.alerts.model.Medicalrecords;

public interface MedicalrecordsRepositoryInterface {

    List<Medicalrecords> getListMedicalrecords();

    List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords);

    Medicalrecords addMedicalrecordToList(String firstNameAndLastName,
            Medicalrecords medicalrecords)
            throws ParseException;

}
