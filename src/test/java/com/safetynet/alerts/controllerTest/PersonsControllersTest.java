package com.safetynet.alerts.controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.safetynet.alerts.model.Persons;

public class PersonsControllersTest {

    @Test
    @DisplayName("Test return status for getListPersons request")
    public void getListPersons() throws Exception {
        // GIVEN
        Persons persons = new Persons(); // creation d'un object Persons
        List<Persons> listPersons = new ArrayList<Persons>(); // creatation de la liste Persons
        persons.setFirstName("monPrenom");
        persons.setLastName("monNom");
        persons.setAddress("8 MaRue");
        persons.setCity("MaVille");
        persons.setZip("88888");
        persons.setPhone("0600000000");
        persons.setEmail("monemail@gmail.com");
        listPersons.add(persons);

    }
}
