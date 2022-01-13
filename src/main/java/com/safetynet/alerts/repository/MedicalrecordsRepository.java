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

    @Override
    public List<Medicalrecords> getListMedicalrecords() {

        return database.getMedicalrecords();
    }
}
