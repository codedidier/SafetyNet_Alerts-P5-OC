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
    @DisplayName("Test getListPersons with new persons to list")
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
}
