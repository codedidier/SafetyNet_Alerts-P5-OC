package com.safetynet.alerts.repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.FirestationsRepository;

@ExtendWith(MockitoExtension.class)
public class FirestationsRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private FirestationsRepository firestationsRepository;

    @Test
    @DisplayName("Test getListFirestationsTest")
    public void getListFirestationsTest() {
        // GIEVEN
        List<Firestations> firestationsList = new ArrayList<Firestations>();

        // WHEN
        when(database.getFirestations()).thenReturn(firestationsList);
        List<Firestations> getListFirestations = firestationsRepository.getListFirestations();
        assertSame(firestationsList, getListFirestations);

        // THEN
        assertTrue(getListFirestations.isEmpty());
        verify(database).getFirestations();
    }

    @Test
    @DisplayName("Test addFirestationToListTest")
    public void addFirestationToListTest() {

        // GIVEN
        List<Firestations> firestationsList = new ArrayList<Firestations>();

        // WHEN
        when(database.getFirestations()).thenReturn(firestationsList);
        List<Firestations> addFirestationToList = firestationsRepository.addFirestationToList(new Firestations());
        assertSame(firestationsList, addFirestationToList);

        // THEN
        assertEquals(1, addFirestationToList.size());
        verify(this.database).getFirestations();
        assertSame(addFirestationToList, this.firestationsRepository.getListFirestations());
    }

    @Test
    @DisplayName("Test updateFirestationToListTest")
    public void updateFirestationToListTest() {

        // GIVEN
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        List<Firestations> firestationsList = new ArrayList<Firestations>();
        firestationsList.add(firestations);

        // WHEN
        when(database.getFirestations()).thenReturn(firestationsList);
        assertNull(firestationsRepository.updateFirestationToList(new Firestations()));

        // THEN
        verify(database).getFirestations();
        assertSame(firestationsList, firestationsRepository.getListFirestations());
    }

    @Test
    @DisplayName("Test updateFirestationToListTest")
    public void deleteFirestationToListTest() {

        // GIVEN
        List<Firestations> firestationsList = new ArrayList<Firestations>();
        firestationsList.add(new Firestations("8 MaRue", 8, new ArrayList<Persons>()));

        // WHEN
        when(database.getFirestations()).thenReturn(firestationsList);
        firestationsRepository.deleteFirestationToList("8 MaRue");
        verify(database).getFirestations();
        List<Firestations> addFirestationToList = firestationsRepository.getListFirestations();

        // THEN
        assertSame(firestationsList, addFirestationToList);
        assertTrue(addFirestationToList.isEmpty());
    }

    @Test
    @DisplayName("Test findByIdTest")
    public void getByIdTest() {
        // GIVEN
        List<Firestations> listFirestation = new ArrayList<Firestations>();
        Firestations firestations = new Firestations("8 MaRue", 8, new ArrayList<Persons>());
        listFirestation.add(firestations);

        // WHEN
        when(database.getFirestations()).thenReturn(listFirestation);
        assertSame(firestations, firestationsRepository.getById("8 MaRue"));
        verify(database).getFirestations();

        // THEN
        assertSame(listFirestation, firestationsRepository.getListFirestations());
    }

    @Test
    @DisplayName("Test getAddressByStationTest")
    public void getAddressByStationTest() {
        // GIVEN
        List<Firestations> listFirestation = new ArrayList<Firestations>();

        // WHEN
        when(database.getFirestations()).thenReturn(listFirestation);
        assertTrue(firestationsRepository.getAddressByStation(10).isEmpty());
        verify(database).getFirestations();

        // THEN
        assertSame(listFirestation, firestationsRepository.getListFirestations());
    }
}
