package com.safetynet.alerts.serviceTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repository.PersonsRepositoryInterface;
import com.safetynet.alerts.service.PersonsService;

@ExtendWith(MockitoExtension.class)
public class PersonsServiceTest {

    private PersonsService personsService;

    @Mock
    private PersonsRepositoryInterface personsRepositoryInterface;

    @BeforeEach
    public void setUp() throws Exception {

        personsService = new PersonsService(personsRepositoryInterface);
    }

    @Test
    @DisplayName("Test getListPersons")
    public void getListPersons() {

        // GIVEN
        List<Persons> listPersons = new ArrayList<>();
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
        when(personsRepositoryInterface.getListPersons()).thenReturn(listPersons);

        // THEN
        assertThat(personsService.getListPersons().toString(), containsString("monPrenom"));
    }

    @Test
    @DisplayName("Test addNewPersonsToList avec une nouvelle personne")
    public void addNewPersonToList() {

        // GIVEN
        List<Persons> listPersons = new ArrayList<Persons>();
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
        when(personsRepositoryInterface.getListPersons()).thenReturn(listPersons);
        personsService.addNewPersonToList(persons);

        // THEN
        assertThat(personsService.addNewPersonToList(persons).toString(), containsString("monPrenom"));

    }

    @Test
    @DisplayName("Test updatePersonToList mettre à jour une personne")
    public void updatePersonToList() {

        // GIVEN
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");

        // WHEN
        when(personsRepositoryInterface.updatePersonToList("monPrenommonNom", persons)).thenReturn(persons);

        // THEN
        assertThat(personsService.updatePersonToList("monPrenommonNom", persons).toString(),
                containsString("monPrenom"));

    }

    @Test
    @DisplayName("Test deletePersonToList supprimer une personne")
    public void deletePersonToList() {

        // GIVEN
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        personsService.addNewPersonToList(persons);

        // WHEN

        // THEN
        assertThat(personsService.deletePersonToList("monPrenommonNom").toString(), containsString(""));

    }

    @Test
    @DisplayName("Test getByAddress")
    public void getByAddress() {
        // GIVEN
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        List<Persons> listPersons = new ArrayList<Persons>();
        listPersons.add(persons);
        // WHEN
        when(personsRepositoryInterface.getByAddress("8 MaRue")).thenReturn(listPersons);

        // THEN
        assertThat(personsService.getByAddress("8 MaRue").toString(), containsString("monPrenom"));
    }

    @Test
    @DisplayName("Test  getByLastName")
    public void getByLastName() {
        // GIVEN
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        List<Persons> listPersons = new ArrayList<Persons>();
        listPersons.add(persons);

        // WHEN
        when(personsRepositoryInterface.getByLastName("monNom")).thenReturn(listPersons);

        // THEN
        assertThat(personsService.getByLastName("monNom").toString(), containsString("monNom"));

    }

    @Test
    @DisplayName("Test  getByFirstNameAndLastName")
    public void getByFirstNameAndLastName() {
        // GIVEN
        Persons persons = new Persons();
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        List<Persons> listPersons = new ArrayList<Persons>();
        listPersons.add(persons);
        // WHEN
        when(personsRepositoryInterface.getByFirstNameAndLastName("monPrenom", "monNom")).thenReturn(listPersons);

        // THEN
        assertThat(personsService.getByFirstNameAndLastName("monPrenom", "monNom")
                .toString(), containsString("monNom"));

    }
}
