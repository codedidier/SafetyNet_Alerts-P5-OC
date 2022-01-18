package com.safetynet.alerts.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Firestations;

import lombok.Data;

@Data
@Repository
public class FirestationsRepository implements FirestationsRepositoryInterface {

    @Autowired
    private Database database;

    public Database getDatabase() {

        return database;
    }

//GET /firestations
    @Override
    public List<Firestations> getListFirestations() {

        return database.getFirestations();
    }

//POST /firestation
    @Override
    public List<Firestations> addFirestationToList(Firestations firestations) {
        List<Firestations> addFirestations = database.getFirestations();
        addFirestations.add(firestations);
        return addFirestations;
    }

//PUT /firestation
    @Override
    public Firestations updateFirestationToList(Firestations firestations) {

        List<Firestations> updateFirestation = database.getFirestations();
        for (Firestations update : updateFirestation) {
            if (update.getAddress().equals(firestations.getAddress())) { ///
                update.setStation(firestations.getStation());
                return update;
            }
        }
        return null;
    }

//DELETE /firestation
    @Override
    public void deleteFirestationToList(String address) {

        List<Firestations> deleteFirestation = database.getFirestations();
        deleteFirestation.removeIf(firestations -> firestations.getAddress().equals(address));

    }
}
