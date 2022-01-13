package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repository.MedicalrecordsRepositoryInterface;

@Service
public class MedicalrecordsService implements MedicalrecordsServiceInterface {

    private static final Logger logger = LogManager.getLogger("MedicalrecordsService");

    @Autowired
    MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface;

    @Autowired
    public MedicalrecordsService(MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface) {

        this.medicalrecordsRepositoryInterface = medicalrecordsRepositoryInterface;
    }

    @Override
    public List<Medicalrecords> getListMedicalrecords() {

        logger.info("getListMedicalrecords SUCCESS :");
        return medicalrecordsRepositoryInterface.getListMedicalrecords();

    }

}
