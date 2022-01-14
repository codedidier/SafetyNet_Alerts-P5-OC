package com.safetynet.alerts.repository;

import java.util.List;

import com.safetynet.alerts.model.Firestations;

public interface FirestationsRepositoryInterface {

//GET /firestations
    List<Firestations> getListFirestations();

//POST /firestation
    List<Firestations> addFirestationToList(Firestations firestations);

//PUT /firestation
    Firestations updateFirestationToList(Firestations firestations);

//DELETE /firestation
    void deleteFirestationToList(String address);
}