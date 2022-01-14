package com.safetynet.alerts.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.alerts.controller.FirestationsController;
import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.service.FirestationsService;

@WebMvcTest(FirestationsController.class)
public class FirestationsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationsService firestationsService;

    @Test
    @DisplayName("Test du retour pour la requête getListFirestations")
    public void getListFirestations() throws Exception {

        // GIVEN
        Firestations firestations = new Firestations(); // creation new object Firestations
        firestations.setAddress("8 MaRue"); // définir l'adresse dans l'object
        firestations.setStation(8); // définir le numéro de la station Firestations
        List<Firestations> firestationsList = new ArrayList<>(); // creation new List de Firestations
        firestationsList.add(firestations); // ajouter l'objet Firestations à la liste des Firestations
        when(firestationsService.getListFirestations()).thenReturn(firestationsList); // lorsque le service est appelé,
                                                                                      // retourne une nouvelle liste
        // WHEN
        mockMvc.perform(get("/firestations")).andExpect(status().isOk()); // Execute la demande avec Get"firestations"

        // THEN
        verify(firestationsService, times(1)).getListFirestations(); // verifie que le service firestationService est
                                                                     // appelé

    }

    @Test
    @DisplayName("Test du retour pour la demande addFirestationToList")
    public void addFirestationToList() throws Exception {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        List<Firestations> firestationsList = new ArrayList<>();
        when(firestationsService.addFirestationToList(any(Firestations.class))).thenReturn(firestationsList);

        // WHEN
        mockMvc.perform(post("/firestation").content("{ \"address\":\"8 MaRue\", \"station\":\"8\" }")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        // THEN
        verify(firestationsService, times(1)).addFirestationToList(any(Firestations.class));

    }

    @Test
    @DisplayName("Test de mise a jour de firestation updateFirestationToList")
    public void updateFirestationToList() throws Exception {
        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        when(firestationsService.updateFirestationToList(any(Firestations.class))).thenReturn(firestations);

        // WHEN
        mockMvc.perform(put("/firestation").content("{ \"address\":\"8 MaRue\", \"station\":\"8\" }")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        // THEN
        verify(firestationsService, times(1)).updateFirestationToList(any(Firestations.class));

    }

    @Test
    @DisplayName("Test supprimer une firestation deleteFirestationToList")
    public void deleteFirestationToList() throws Exception {
        // GIVEN

        // WHEN
        mockMvc.perform(delete("/firestation/station")).andExpect(status().isOk());

        // THEN
        verify(firestationsService, times(1)).deleteFirestationToList(any(String.class));

    }
}
