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
import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.PersonsRepository;

@ExtendWith(MockitoExtension.class)
public class PersonsRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private PersonsRepository personsRepository;

    @Test
    @DisplayName("Test getListPersonsTest")
    public void getListPersonsTest() {
        // GIVEN
        List<Persons> personsList = new ArrayList<Persons>();

        // WHEN
        when(database.getPersons()).thenReturn(personsList);
        List<Persons> getListPersons = personsRepository.getListPersons();
        assertSame(personsList, getListPersons);
        assertTrue(getListPersons.isEmpty());

        // THEN
        verify(database).getPersons();
    }

    @Test
    @DisplayName("Test addNewPersonToListTest")
    public void addNewPersonToListTest() {
        // GIVEN
        List<Persons> personsList = new ArrayList<Persons>();

        // WHEN
        when(database.getPersons()).thenReturn(personsList);
        List<Persons> addNewPersonToList = personsRepository.addNewPersonToList(new Persons());
        assertSame(personsList, addNewPersonToList);
        assertEquals(1, addNewPersonToList.size());

        // THEN
        verify(database).getPersons();
        assertSame(addNewPersonToList, personsRepository.getListPersons());
    }

    @Test
    @DisplayName("Test updatePersonToListTest")
    public void updatePersonToListTest() {
        // GIVEN
        List<Persons> personsList = new ArrayList<Persons>();

        // WHEN
        when(database.getPersons()).thenReturn(personsList);
        assertNull(personsRepository.updatePersonToList("monPrenom", new Persons()));

        // THEN
        verify(database).getPersons();
        assertSame(personsList, personsRepository.getListPersons());
    }

    @Test
    @DisplayName("Test deletePersonToListTest")
    public void deletePersonToListTest() {
        // GIVEN
        List<Persons> personsList = new ArrayList<Persons>();

        // WHEN
        when(database.getPersons()).thenReturn(personsList);
        personsRepository.deletePersonToList("monPrenom");
        verify(database).getPersons();
        List<Persons> getListPersonsResult = personsRepository.getListPersons();

        // THEN
        assertSame(personsList, getListPersonsResult);
        assertTrue(getListPersonsResult.isEmpty());
    }

}
