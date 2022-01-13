package com.safetynet.alerts.repositoryTest;

import static org.junit.Assert.assertEquals;
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
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repository.MedicalrecordsRepository;

@ExtendWith(MockitoExtension.class)
public class MedicalrecordsRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private MedicalrecordsRepository medicalrecordsRepository;

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

}