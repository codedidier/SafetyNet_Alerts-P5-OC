package com.safetynet.alerts.serviceTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.repositoryInterface.FirestationsRepositoryInterface;
import com.safetynet.alerts.service.FirestationsService;

@ExtendWith(MockitoExtension.class)
public class FirestationsServiceTest {

    private FirestationsService firestationsService;

    @Mock
    private FirestationsRepositoryInterface firestationsRepositoryInterface;

    @BeforeEach
    public void setUp() {

        firestationsService = new FirestationsService(firestationsRepositoryInterface);
    }

    @Test
    @DisplayName("Test getListFirestations numero de station et addresse")
    public void getListFirestations() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        List<Firestations> firestationsList = new ArrayList<Firestations>();
        firestationsList.add(firestations);

        // WHEN
        when(firestationsRepositoryInterface.getListFirestations()).thenReturn(firestationsList);

        // THEN
        assertEquals(firestationsService.getListFirestations().size(), 1);
    }

    @Test
    @DisplayName("Test addFirestationToList ajout de l'adresse et d'un numero de station")
    public void addFirestationToList() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        List<Firestations> firestationsList = new ArrayList<Firestations>();
        firestationsList.add(firestations);

        // WHEN
        when(firestationsRepositoryInterface.getListFirestations()).thenReturn(firestationsList);

        // THEN
        assertEquals(firestationsService.getListFirestations().size(), 1);
    }

    @Test
    @DisplayName("Test updatePersonToList mise àn jour d'une station")
    public void updatePersonToList() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);

        // WHEN
        when(firestationsRepositoryInterface.updateFirestationToList(firestations)).thenReturn(firestations);

        // THEN
        assertThat(firestationsService.updateFirestationToList(firestations).toString(), containsString("8 MaRue"));

    }

    @Test
    @DisplayName("Test deleteFirestationToList avec une adresse")
    public void deleteFirestationToListfalse() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationsService.addFirestationToList(firestations);

        // WHEN
        firestationsRepositoryInterface.deleteFirestationToList("8 MaRue");

        // THEN

        assertEquals(firestationsService.deleteFirestationToList("8 MaRue"), false);

    }

    @Test
    @DisplayName("Test deleteFirestationToList avec une adresse")
    public void deleteFirestationToListtrue() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationsService.addFirestationToList(firestations);

        // WHEN
        firestationsRepositoryInterface.deleteFirestationToList("8 MaRue");

        // THEN

        assertEquals(firestationsService.deleteFirestationToList(null), false);
    }

    @Test
    @DisplayName("Test getById")
    public void getById() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationsService.addFirestationToList(firestations);
        // WHEN
        when(firestationsRepositoryInterface.getById("8 MaRue")).thenReturn(firestations);
        // THEN
        assertThat(firestationsService.getById("8 MaRue").toString(), containsString("8 MaRue"));
    }

    @Test
    @DisplayName("Test getAddressByStation")
    public void getAddressByStation() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        List<Firestations> firestationList = new ArrayList<Firestations>();
        firestationList.add(firestations);
        // WHEN
        when(firestationsRepositoryInterface.getAddressByStation(8)).thenReturn(firestationList);
        // THEN
        assertThat(firestationsService.getAddressByStation(8).toString(), containsString("8"));
    }
}
