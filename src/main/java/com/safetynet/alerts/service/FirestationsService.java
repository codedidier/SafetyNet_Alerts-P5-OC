package com.safetynet.alerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.repository.FirestationsRepositoryInterface;

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

    @Override
    public List<Firestations> getListFirestations() {

        Log.info("getListFirestations SUCCESS :");
        return firestationsRepositoryInterface.getListFirestations();

    }

}
