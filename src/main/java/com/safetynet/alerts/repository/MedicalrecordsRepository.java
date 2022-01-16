package com.safetynet.alerts.repository;

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

//PUT /medicalRecord
    @Override
    public Medicalrecords updateMedicalrecordToList(String firstNameAndLastName, Medicalrecords medicalrecords) {

        for (Medicalrecords updateMedical : database.getMedicalrecords()) {
            if (updateMedical.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                updateMedical.setBirthdate(medicalrecords.getBirthdate());
                updateMedical.setMedications(medicalrecords.getMedications());
                updateMedical.setAllergies(medicalrecords.getAllergies());
                return updateMedical;
            }
        }
        return null;
    }

//DELETE /medicalRecord
    @Override
    public void deleteMedicalrecordToList(String firstNameAndLastName) {

        database.getMedicalrecords()
                .removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName));

    }

}
