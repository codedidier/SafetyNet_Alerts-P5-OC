package com.safetynet.alerts.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.service.FirestationsService;

@WebMvcTest
public class FirestationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationsService firestationsService;

    @Test
    @DisplayName("Test return status for getListFirestations request")
    public void getListFirestations() throws Exception {

        // GIVEN
        Firestations firestations = new Firestations(); // creation new object Firestations
        firestations.setAddress("8 MaRue"); // définir l'adresse dans l'object
        firestations.setStation(8); // définir le numéro de la station Firestations
        List<Firestations> firestationsList = new ArrayList<>(); // creation new List de Firestations
        firestationsList.add(firestations); // ajouter l'objet Firestations à la liste des Firestations

        // WHEN
        mockMvc.perform(get("/firestations")).andExpect(status().isOk()); // Execute la demande avec Get"firestations"

        // THEN
        verify(firestationsService, times(1)).getListFirestations(); // verifie quand le service firestationService est
                                                                     // appelé

    }
}
