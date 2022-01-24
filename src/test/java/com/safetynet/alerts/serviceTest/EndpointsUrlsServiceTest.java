package com.safetynet.alerts.serviceTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.dto.ChildAlertWithAgeDto;
import com.safetynet.alerts.dto.FireDto;
import com.safetynet.alerts.dto.FloodDto;
import com.safetynet.alerts.dto.PersonInfoDto;
import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.FirestationsRepositoryInterface;
import com.safetynet.alerts.repository.MedicalrecordsRepositoryInterface;
import com.safetynet.alerts.repository.PersonsRepositoryInterface;
import com.safetynet.alerts.service.EndpointsUrlsService;
import com.safetynet.alerts.service.ExtractAge;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@WebMvcTest(EndpointsUrlsService.class)
@SpringBootTest
public class EndpointsUrlsServiceTest {

    @Mock
    private static PersonsRepositoryInterface personsRepositoryInterface;

    @Mock
    private static FirestationsRepositoryInterface firestationsRepositoryInterface;

    @Mock
    private static MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface;

    @Mock
    private ExtractAge extractAge = new ExtractAge();

    @InjectMocks
    private static EndpointsUrlsService endpointsUrlsService;

    List<Persons> listPersons;

    @BeforeAll
    static void setUp() {

        endpointsUrlsService = new EndpointsUrlsService(personsRepositoryInterface, firestationsRepositoryInterface,
                medicalrecordsRepositoryInterface);
    }

    // URL firestation
    @Test
    @DisplayName("listPersonsByStationTest url /firestation")
    public void listPersonsByStationTest() throws ParseException {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);
        List<Firestations> firestationList = new ArrayList<>();
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationList.add(firestations);

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
        when(personsRepositoryInterface.getByAddress("8 MaRue")).thenReturn(listPersons);
        when(firestationsRepositoryInterface.getAddressByStation(any(int.class))).thenReturn(firestationList);
        when(medicalrecordsRepositoryInterface.getByFirstName(persons.getFirstName())).thenReturn(medicalrecords);

        assertNotNull(endpointsUrlsService.listPersonsByStation(2));

        // THEN
        for (Persons persons1 : endpointsUrlsService.listPersonsByStation(2).getListPersonsStation()) {
            assertThat(persons1.getFirstName(), containsString("monPrenom"));
        }
    }

    // URL childAlert
    @Test
    @DisplayName("listChildByAddressTest url /childAlert")
    public void listChildByAddressTest() throws ParseException {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);
        List<Firestations> firestationList = new ArrayList<>();
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationList.add(firestations);

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

        when(personsRepositoryInterface.getByAddress(any(String.class))).thenReturn(listPersons);
        when(medicalrecordsRepositoryInterface.getByFirstName(any(String.class))).thenReturn(medicalrecords);

        // THEN
        for (ChildAlertWithAgeDto childByAddressDto : endpointsUrlsService.listChildByAddress("8 MaRue")
                .getChildren()) {
            assertThat(childByAddressDto.getFirstName(), containsString("monPrenom"));
            assertThat(childByAddressDto.getLastName(), containsString("monNom"));

        }
    }

    // URL phoneAlert
    @Test
    @DisplayName("listPhoneByFirestationTest url /phoneAlert")
    public void listPhoneByFirestationTest() {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);
        List<Firestations> firestationList = new ArrayList<>();
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationList.add(firestations);

        // WHEN
        when(personsRepositoryInterface.getByAddress("8 MaRue")).thenReturn(listPersons);
        when(firestationsRepositoryInterface.getAddressByStation(8)).thenReturn(firestationList);

        // THEN
        assertThat(endpointsUrlsService.listPhoneByFirestation(7)
                .getListPhonesCity()
                .toString(), containsString("0600000000"));
    }

    // URL fire
    @Test
    @DisplayName("listPersonsByAddressAndStationNumberTest url /fire")
    public void listPersonsByAddressAndStationNumberTest() throws ParseException {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);
        List<Firestations> firestationList = new ArrayList<>();
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationList.add(firestations);

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
        when(personsRepositoryInterface.getByAddress("8 MaRue")).thenReturn(listPersons);
        when(medicalrecordsRepositoryInterface.getByFirstName("monPrenom")).thenReturn(medicalrecords);
        when(firestationsRepositoryInterface.getById("8 MaRue")).thenReturn(firestations);

        // THEN
        for (FireDto fireAddressDto : endpointsUrlsService.listPersonsByAddressAndStationNumber("8 MaRue")
                .getListPersonsByAddress()) {
            assertThat(fireAddressDto.getLastName().toString(), containsString("monNom"));
        }

    }

    // URL flood
    @Test
    @DisplayName("listHomeByStationTest url /flood")
    public void listHomeByStationTest() throws ParseException {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);
        List<Firestations> firestationList = new ArrayList<>();
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationList.add(firestations);

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

        List<Integer> stations = new ArrayList<>();
        stations.add(1);
        stations.add(2);

        // WHEN
        when(personsRepositoryInterface.getByAddress("8 MaRue")).thenReturn(listPersons);
        when(medicalrecordsRepositoryInterface.getByFirstName(persons.getFirstName())).thenReturn(medicalrecords);
        when(firestationsRepositoryInterface.getAddressByStation(any(int.class))).thenReturn(firestationList);

        // THEN
        List<FloodDto> listHomeByStation = endpointsUrlsService.listHomeByStation(stations);
        for (FloodDto floodDton : listHomeByStation) {
            assertThat(floodDton.getLastName(), containsString("monNom"));
        }
    }

    // URL personInfo
    @Test
    @DisplayName("listPersonInfoTest url /personInfo")
    public void listPersonInfoTest() throws ParseException {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);
        List<Firestations> firestationList = new ArrayList<>();
        Firestations firestations = new Firestations();
        firestations.setAddress("8 MaRue");
        firestations.setStation(8);
        firestationList.add(firestations);

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
        when(personsRepositoryInterface.getByFirstNameAndLastName("monPrenom", "monNom")).thenReturn(listPersons);
        when(medicalrecordsRepositoryInterface.getByFirstName(persons.getFirstName())).thenReturn(medicalrecords);

        // THEN

        for (PersonInfoDto personInfo : endpointsUrlsService.listPersonInfo("monPrenom", "monNom")) {
            assertThat(personInfo.getLastName(), containsString("monNom"));
            assertThat(personInfo.getEmail(), containsString("monemail@gmail.com"));

            assertThat(personInfo.getMedications().toString(), containsString(medications.toString()));
            assertThat(personInfo.getAllergies().toString(), containsString(allergies.toString()));

        }
    }

    // URL communityEmail
    @Test
    @DisplayName("communityEmailTest url /communityEmail")
    public void communityEmailTest() {

        // GIVEN
        listPersons = new ArrayList<>();
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);

        // WHEN
        when(personsRepositoryInterface.getEmailByCity("MaVille")).thenReturn(listPersons);

        // THEN
        assertThat(endpointsUrlsService.listEmailsByCity("MaVille")
                .getListEmails()
                .toString(), containsString("monemail@gmail.com"));

    }
}
