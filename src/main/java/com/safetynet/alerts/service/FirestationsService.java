package com.safetynet.alerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.repositoryInterface.FirestationsRepositoryInterface;
import com.safetynet.alerts.serviceInterface.FirestationsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FirestationsService implements FirestationsServiceInterface {

    @Autowired
    FirestationsRepositoryInterface firestationsRepositoryInterface;

    @Autowired
    public FirestationsService(FirestationsRepositoryInterface firestationsRepositoryInterface) {

        this.firestationsRepositoryInterface = firestationsRepositoryInterface;
    }

//GET /firestations
    @Override
    public List<Firestations> getListFirestations() {

        log.info("getListFirestations SUCCESS :");

        return firestationsRepositoryInterface.getListFirestations();
    }

//POST /firestation
    @Override
    public List<Firestations> addFirestationToList(Firestations firestations) {

        log.info("Firestations saved SUCCESS :" + firestations);
        firestationsRepositoryInterface.addFirestationToList(firestations);
        return firestationsRepositoryInterface.getListFirestations();
    }

//PUT /firestation
    @Override
    public Firestations updateFirestationToList(Firestations firestations) {

        log.info("updateFirestationToList rèussis" + firestations);
        return firestationsRepositoryInterface.updateFirestationToList(firestations);
    }

//DELETE /firestation
    @Override
    public List<Firestations> deleteFirestationToList(String address) {

        log.info("deleteFirestationToList réussi :" + address);
        firestationsRepositoryInterface.deleteFirestationToList(address);
        return firestationsRepositoryInterface.getListFirestations();
    }

//URLS
    @Override
    public Firestations getById(String firestationAddress) {

        log.info("getById OK :" + firestationAddress);
        return firestationsRepositoryInterface.getById(firestationAddress);

    }

    @Override
    public List<Firestations> getAddressByStation(int stationNumber) {

        log.info("getAddressByStation SUCCESS :" + stationNumber);
        return firestationsRepositoryInterface.getAddressByStation(stationNumber);
    }
}
