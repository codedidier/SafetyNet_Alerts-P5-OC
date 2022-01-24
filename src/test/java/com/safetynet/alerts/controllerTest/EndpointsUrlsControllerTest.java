package com.safetynet.alerts.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.alerts.controller.EndpointsUrlsController;
import com.safetynet.alerts.service.EndpointsUrlsService;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@WebMvcTest(EndpointsUrlsController.class)
@SpringBootTest
public class EndpointsUrlsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    EndpointsUrlsService endpointsUrlsService;

// URL firestation
  
    @DisplayName("Test de retour du statut 200 pour un numéro stationNumber valide")
    public void listPersonsByStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=2")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de retour du statut 200 pour un numéro stationNumber null")
    public void listPersonsByStationNullTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test de retour du statut 200 pour un nom stationNumber incorect")
    public void listPersonsByStationErrorStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=test ")).andExpect(status().isBadRequest());
    }

    // URL childAlerts
    @Test
    @DisplayName("Test de retour du statut 200 pour une address valide")
    public void listChildByAddressTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=8 MaRue")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de retour du statut 200 pour une adresse invalide")
    public void listChildByAddressNullTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=")).andExpect(status().isOk());
    }

    // URL phoneAlert
    @Test
    @DisplayName("Test de retour du statut 200 pour un numéro de caserne valide")
    public void listPhoneByFirestationTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?firestation=2")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de retour du statut 200 pour un numéro de firestation invalide")
    public void listPhoneByFirestationErrorTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?firestation=a")).andExpect(status().isBadRequest());
    }

    // URL fire
    @Test
    @DisplayName("Test de retour du statut 200 pour une adresse valide de firestation")
    public void listPersonsByAddressAndStationNumberTest() throws Exception {
        mockMvc.perform(get("/fire?address=29 15th St")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de retour du statut 200 noFound adresse firestation")
    public void listPersonsByAddressAndStationNumberNoFoundTest() throws Exception {
        mockMvc.perform(get("/fire?address=")).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test de retour du statut 200 error address firestation")
    public void listPersonsByAddressAndStationNumberErrorTest() throws Exception {
        mockMvc.perform(get("/fire?address=errorAddress")).andExpect(status().isNotFound());
    }

    // URL flood
    @Test
    @DisplayName("Test de retour du statut 200 pour un numéro valide de firestation")
    public void listHomeByStationTest() throws Exception {
        mockMvc.perform(get("/flood/stations?stations=2")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de retour du statut 200 pour une firestation sans numéro")
    public void listHomeByStationNoExistTest() throws Exception {
        mockMvc.perform(get("/flood/stations?stations=")).andExpect(status().isOk());
    }

    // URL personinfo
    @Test
    @DisplayName("Test de retour du statut 200 pour un prénom et un nom valides pour personInfo")
    public void listPersonInfoTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test de retour du statut 200 pour l'absence de prénom et de nom de famille pour personInfo")
    public void listPersonInfoNoExistTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=&lastname")).andExpect(status().isBadRequest());
    }

    // URL communityEmail
    @Test
    @DisplayName("Test de retour du statut 200 pour une ville valides pour communityEmail")
    public void listEmailsByCityTest() throws Exception {
        mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk());
    }
}
