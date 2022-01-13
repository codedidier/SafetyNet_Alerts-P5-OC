package com.safetynet.alerts.repository;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Medicalrecords;

@Repository
public class MedicalrecordsRepository implements MedicalrecordsRepositoryInterface {

    @Autowired
    Database database;

    @Autowired
    public MedicalrecordsRepository(Database database) {
        this.database = database;
    }

//GET /medicalrecords
    @Override
    public List<Medicalrecords> getListMedicalrecords() {

        return database.getMedicalrecords();
    }

//Post /medicalRecord
    @Override
    public List<Medicalrecords> addMedicalrecordToList(Medicalrecords medicalrecords) {

        List<Medicalrecords> saveMedical = database.getMedicalrecords();
        saveMedical.add(medicalrecords);
        return saveMedical;
    }

    @Override
    public Medicalrecords addMedicalrecordToList(String firstNameAndLastName, Medicalrecords medicalrecords)
            throws ParseException {

        for (Medicalrecords addMedical : database.getMedicalrecords()) {
            if (addMedical.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                addMedical.setBirthdate(medicalrecords.getBirthdate());
                addMedical.setMedications(medicalrecords.getMedications());
                addMedical.setAllergies(medicalrecords.getAllergies());
                return addMedical;
            }
        }
        return null;
    }

}
