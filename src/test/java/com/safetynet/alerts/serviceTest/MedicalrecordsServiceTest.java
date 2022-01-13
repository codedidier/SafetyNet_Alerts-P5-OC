package com.safetynet.alerts.serviceTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.repository.MedicalrecordsRepositoryInterface;
import com.safetynet.alerts.service.MedicalrecordsService;

@ExtendWith(MockitoExtension.class)
public class MedicalrecordsServiceTest {

    private MedicalrecordsService medicalrecordsService;

    @Mock
    private MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface;

    @BeforeEach
    public void setUp() throws Exception {

        medicalrecordsService = new MedicalrecordsService(medicalrecordsRepositoryInterface);
    }

    @Test
    @DisplayName("Test getListMedicalrecords")
    public void getListMedicalrecords() {
        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        List<String> medications = new ArrayList<>();
        medications.add("doliprane 1000g");
        medications.add("aspirine 20mg");
        List<String> allergies = new LinkedList<>();
        allergies.add("gluten");
        allergies.add("chat");
        List<Medicalrecords> medicalrecordsList = new ArrayList<>();
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);
        medicalrecordsList.add(medicalrecords);

        // WHEN
        when(medicalrecordsRepositoryInterface.getListMedicalrecords()).thenReturn(medicalrecordsList);

        // THEN
        assertThat(medicalrecordsService.getListMedicalrecords().toString(), containsString("monPrenom"));
    }
}
