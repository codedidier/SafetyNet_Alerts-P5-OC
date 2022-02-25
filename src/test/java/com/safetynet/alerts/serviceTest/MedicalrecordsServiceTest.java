package com.safetynet.alerts.serviceTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.safetynet.alerts.repositoryInterface.MedicalrecordsRepositoryInterface;
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
        assertEquals(medicalrecordsService.getListMedicalrecords().size(), 1);
        assertThat(medicalrecordsService.getListMedicalrecords().toString(), containsString("monPrenom"));
    }

    @Test
    @DisplayName("Test addMedicalrecordToList ")
    public void addMedicalrecordToList() {
        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        List<String> medications = new ArrayList<String>();
        medications.add("doliprane 1000g");
        medications.add("aspirine 20mg");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gluten");
        allergies.add("chat");
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);
        medicalrecordList.add(medicalrecords);

        // WHEN
        when(medicalrecordsRepositoryInterface.addMedicalrecordToList(medicalrecords)).thenReturn(medicalrecordList);

        // THEN
        assertEquals(medicalrecordsService.addMedicalrecordToList(medicalrecords).size(), 1);
        assertThat(medicalrecordsService.addMedicalrecordToList(medicalrecords).toString(),
                containsString("monPrenom"));
    }

    @Test
    @DisplayName("Test updateMedicalrecordToList")
    public void updateMedicalrecordToList() {

        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        List<String> medications = new ArrayList<String>();
        medications.add("doliprane 1000g");
        medications.add("aspirine 20mg");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gluten");
        allergies.add("chat");
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);
        medicalrecords.setAge(22);
        medicalrecordList.add(medicalrecords);

        // WHEN
        when(medicalrecordsRepositoryInterface.updateMedicalrecordToList("monPrenommonNom", medicalrecords))
                .thenReturn(medicalrecords);

        // THEN
        assertThat(medicalrecordsService.updateMedicalrecordToList("monPrenommonNom", medicalrecords).toString(),
                containsString("monPrenom"));

    }

    @Test
    @DisplayName("Test deletePersonToList")
    public void deletePersonToList() {

        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        List<String> medications = new ArrayList<String>();
        medications.add("doliprane 1000g");
        medications.add("aspirine 20mg");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gluten");
        allergies.add("chat");
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);
        medicalrecordsService.addMedicalrecordToList(medicalrecords);

        // WHEN
        medicalrecordsRepositoryInterface.deleteMedicalrecordToList("monPrenommonNom");

        // THEN
        assertDoesNotThrow(() -> medicalrecordsService.deleteMedicalrecordToList("monPrenommonNom"));
        verify(medicalrecordsRepositoryInterface, times(1)).getListMedicalrecords();

    }

    @Test
    @DisplayName("Test getByFirstName")
    public void getByFirstName() {

        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        List<String> medications = new ArrayList<String>();
        medications.add("doliprane 1000g");
        medications.add("aspirine 20mg");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gluten");
        allergies.add("chat");
        List<Medicalrecords> medicalrecordList = new ArrayList<Medicalrecords>();
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);
        medicalrecordList.add(medicalrecords);

        // WHEN
        when(medicalrecordsRepositoryInterface.getByFirstName("monPrenom")).thenReturn(medicalrecords);

        // THEN
        assertThat(medicalrecordsRepositoryInterface.getByFirstName("monPrenom").toString(),
                containsString("monPrenom"));
        assertThat(medicalrecordsService.getByFirstName("monPrenom").toString(),
                containsString("monPrenom"));

    }

    @Test
    @DisplayName("Test getByFirstNameAndLastName")
    public void getByFirstNameAndLastName() {
        // GIVEN
        Medicalrecords medicalrecords = new Medicalrecords();
        List<String> medications = new ArrayList<String>();
        medications.add("doliprane 1000g");
        medications.add("aspirine 20mg");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gluten");
        allergies.add("chat");
        medicalrecords.setFirstName("monPrenom");
        medicalrecords.setLastName("monNom");
        medicalrecords.setBirthdate("01/01/2000");
        medicalrecords.setMedications(medications);
        medicalrecords.setAllergies(allergies);
        // WHEN
        when(medicalrecordsRepositoryInterface.getByFirstNameAndLastName("monPrenom", "monNom"))
                .thenReturn(medicalrecords);

        // THEN
        assertThat(medicalrecordsService.getByFirstNameAndLastName("monPrenom", "monNom")
                .toString(), containsString("monNom"));

    }
}
