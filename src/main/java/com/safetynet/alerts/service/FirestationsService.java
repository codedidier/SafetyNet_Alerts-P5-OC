package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.repository.FirestationsRepositoryInterface;

@Service
public class FirestationsService implements FirestationsServiceInterface {

    private static final Logger logger = LogManager.getLogger("FirestationsService");

    @Autowired
    FirestationsRepositoryInterface firestationsRepositoryInterface;

    @Autowired
    public FirestationsService(FirestationsRepositoryInterface firestationsRepositoryInterface) {

        this.firestationsRepositoryInterface = firestationsRepositoryInterface;
    }

    @Override
    public List<Firestations> getListFirestations() {

        logger.info("getListFirestations SUCCESS :");

        return firestationsRepositoryInterface.getListFirestations();

    }

}
