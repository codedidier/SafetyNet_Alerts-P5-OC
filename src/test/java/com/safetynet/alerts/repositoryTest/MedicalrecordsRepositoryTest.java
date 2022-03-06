package com.safetynet.alerts.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repository.MedicalrecordsRepository;

@ExtendWith(MockitoExtension.class)
public class MedicalrecordsRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private MedicalrecordsRepository medicalrecordsRepository;

    @Test
    public void contextLoads() {
        assertNotNull(medicalrecordsRepository);
    }

    @Test
    public void getAllMedicalRecords() {
        List<Medicalrecords> medicalRecords = database.getMedicalrecords();
        List<Medicalrecords> medicalrecordsResult = medicalrecordsRepository.getListMedicalrecords();
        assertNotNull(medicalRecords);
        assertNotNull(medicalrecordsResult);
        assertEquals(medicalrecordsResult, medicalRecords);
    }

    @Test
    @DisplayName("Test getListMedicalrecords")
    public void getListMedicalrecordsTest() {
        // GIVEN
        List<Medicalrecords> medicalrecordsList = new ArrayList<Medicalrecords>();

        // WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordsList);
        List<Medicalrecords> getListMedicalrecords = medicalrecordsRepository.getListMedicalrecords();

        // THEN
        assertSame(medicalrecordsList, getListMedicalrecords);
        assertTrue(getListMedicalrecords.isEmpty());
        verify(database).getMedicalrecords();
    }

    @Test
    @DisplayName("Test addMedicalrecord")
    public void addMedicalrecordToListTest() {
        // GIVEN
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();

        // WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        List<Medicalrecords> addMedicalrecordToListResult = medicalrecordsRepository
                .addMedicalrecordToList(new Medicalrecords());
        assertSame(medicalrecordList, addMedicalrecordToListResult);
        assertEquals(1, addMedicalrecordToListResult.size());

        // THEN
        verify(database).getMedicalrecords();
        assertSame(addMedicalrecordToListResult, medicalrecordsRepository.getListMedicalrecords());
    }

    @Test
    public void addMedicalrecords() {
        List<Medicalrecords> medicalRecords = database.getMedicalrecords();
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        Medicalrecords medicalRecord = new Medicalrecords("monNom", "monPrenom", "01/01/2000", medications, allergies,
                0, null);
        List<Medicalrecords> medicalRecordResult = medicalrecordsRepository.addMedicalrecordToList(medicalRecord);
        @SuppressWarnings("unlikely-arg-type")
        boolean result = medicalRecords.contains(medicalRecordResult);
        assertEquals(result, false);
    }

    @Test
    @DisplayName("Test UpdateMedicalRecordToList")
    public void updateMedicalrecordToListTest() throws ParseException {
        // GIVEN
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();

        Medicalrecords updateMedical = new Medicalrecords();
        updateMedical.setBirthdate(null);
        updateMedical.setMedications(null);
        updateMedical.setAllergies(null);
        medicalrecordList.add(updateMedical);
        // WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        List<Medicalrecords> updateMedicalrecordToListResult = medicalrecordsRepository
                .addMedicalrecordToList(new Medicalrecords());
        assertSame(medicalrecordList, updateMedicalrecordToListResult);

        assertNull(medicalrecordsRepository.updateMedicalrecordToList("monPrenommonNom", new Medicalrecords()));

        // THEN

        assertSame(medicalrecordList, medicalrecordsRepository.getListMedicalrecords());

    }

    @Test
    public void updateMedicalrecordToList() {
        List<Medicalrecords> medicalRecords = database.getMedicalrecords();
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        Medicalrecords medicalRecord = new Medicalrecords("monNommonPrenom", "01/01/2000", null, medications, allergies,
                0, null);
        List<Medicalrecords> medicalRecordResult = medicalrecordsRepository.addMedicalrecordToList(medicalRecord);
        @SuppressWarnings("unlikely-arg-type")
        boolean result = medicalRecords.contains(medicalRecordResult);
        assertEquals(result, false);
    }

    @Test
    @DisplayName("Test DeleteMEdicalrecordList")
    public void deleteMedicalrecordListTest() {
        // GIVEN
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();

        // WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        medicalrecordsRepository.deleteMedicalrecordToList("monPrenommonNom");

        // THEN
        verify(database).getMedicalrecords();
        List<Medicalrecords> getListMedicalrecords = medicalrecordsRepository.getListMedicalrecords();
        assertSame(medicalrecordList, getListMedicalrecords);
        assertTrue(getListMedicalrecords.isEmpty());
    }

    @Test
    public void deleteMedicalRecords() {
        boolean isRemoved = medicalrecordsRepository.deleteMedicalrecordToList("monPrenommonNom");
        assertEquals(isRemoved, false);
    }

    @Test
    @DisplayName("Test getByFirstName")
    public void getByFirstNameTest() {
        // GIVEN
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();

        // WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        assertNull(medicalrecordsRepository.getByFirstName("monPrenom"));

        // THGEN
        verify(database).getMedicalrecords();
        assertSame(medicalrecordList, medicalrecordsRepository.getListMedicalrecords());
    }

    @Test
    @DisplayName("Test getByFirstNameAndLAstName")
    public void getByFirstNameAndLastNameTest() {
        // GIVEN
        List<Medicalrecords> medicalrecords = new ArrayList<Medicalrecords>();

        // WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecords);
        assertNull(medicalrecordsRepository.getByFirstNameAndLastName("monPrenom", "monNom"));
        // THEN
        verify(database).getMedicalrecords();
        assertSame(medicalrecords, medicalrecordsRepository.getListMedicalrecords());
        assertThat(medicalrecordsRepository.getByFirstNameAndLastName("monPrenom", "monNom"));
    }

    @Test
    public void getByFirstNameAndLastName() {
        List<Medicalrecords> medicalRecords = database.getMedicalrecords();
        assertNotNull(medicalRecords);

        equals(null);
    }
}
