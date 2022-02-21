package com.safetynet.alerts.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repositoryInterface.MedicalrecordsRepositoryInterface;

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
                .removeIf(medicalrecords -> medicalrecords.getFirstNameAndLastName().equals(firstNameAndLastName));
    }

//URLS
    @Override
    public Medicalrecords getByFirstName(String firstName) {

        for (Medicalrecords medicalRecords : database.getMedicalrecords()) {
            if (medicalRecords.getFirstName().equals(firstName)) {
                return medicalRecords;
            }
        }
        return null;
    }

    @Override
    public Medicalrecords getByFirstNameAndLastName(String firstName, String lastName) {

        for (Medicalrecords medicalRecords : database.getMedicalrecords()) {
            if (medicalRecords.getFirstName().equals(firstName) && (medicalRecords.getLastName().equals(lastName))) {
                return medicalRecords;
            }
        }
        return null;
    }
}
