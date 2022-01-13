package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.Medicalrecords;

public interface MedicalrecordsServiceInterface {

    List<Medicalrecords> getListMedicalrecords();

    List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords);

}
