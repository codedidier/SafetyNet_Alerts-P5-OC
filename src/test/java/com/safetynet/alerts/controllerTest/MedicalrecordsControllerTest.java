package com.safetynet.alerts.controllerTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.controller.MedicalrecordsController;
import com.safetynet.alerts.model.Medicalrecords;

@SpringBootTest
@WebMvcTest(MedicalrecordsController.class)
public class MedicalrecordsControllerTest {

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

        List<Medicalrecords> listMedicalrecords = new ArrayList<Medicalrecords>(); // creation d'une nouvelle liste
                                                                                   // MedicalRecords
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);

        listMedicalrecords.add(medicalrecords);

        // medications.equals(("doliprane 1000g") + ("aspirine 20 mg"));
        // allergies.equals(("gluten") + ("chat"));
        // listMedicalrecords.equals("monPrenom" + "monNom" + "01/01/2000" + medications
        // + allergies);
    }
}
