package com.safetynet.alerts.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.service.FirestationsServiceInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class FirestationsController {

    @Autowired
    private FirestationsServiceInterface firestationsServiceInterface;

    @GetMapping(value = "/firestations")
    public List<Firestations> getListFirestations() {

        List<Firestations> getFirestations = firestationsServiceInterface.getListFirestations();
        if (getFirestations != null) {
            log.info("getFirestations GET request SUCCESS");
        } else {
            log.error("getFirestations GET request FAILED");
        }
        return getFirestations();
    }

}
