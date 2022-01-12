package com.safetynet.alerts.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.alerts.controller.MedicalrecordsController;
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.service.MedicalrecordsService;

@WebMvcTest(MedicalrecordsController.class)
public class MedicalrecordsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalrecordsService medicalrecordsService;

    @Test
    @DisplayName("Test return status for getListMedicalrecords request")
    public void getListMedicalrecords() throws Exception {

        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords(); // création d'un object Medicalrecords

        List<String> medications = new ArrayList<String>(); // création d'une liste medications
        medications.add("doliprane 1000g"); // ajout d'un produit à la liste medications
        medications.add("aspirine 20mg"); // ajout d'un produit à la liste medications

        List<String> allergies = new LinkedList<String>(); // creation de la liste allergies
        allergies.add("gluten"); // ajout d'une allergie à la liste allergies
        allergies.add("chat"); // ajout d'une allergie à la liste allergies

        List<Medicalrecords> medicalrecordsList = new ArrayList<Medicalrecords>(); // creation d'une nouvelle liste
                                                                                   // MedicalRecords
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);

        medicalrecordsList.add(medicalrecords);

        when(medicalrecordsService.getListMedicalrecords()).thenReturn(medicalrecordsList); // retourne la nouvelle
                                                                                            // liste quand le service
                                                                                            // est appelé

        // WHEN
        mockMvc.perform(get("/medicalRecords"))
                .andExpect(status().isOk()); // Execute la demande Get de "medicalrecords"

        // THEN
        verify(medicalrecordsService, times(1)).getListMedicalrecords(); // verifie que firestationService est appelé

    }
}
