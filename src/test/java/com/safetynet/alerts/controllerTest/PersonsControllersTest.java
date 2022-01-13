package com.safetynet.alerts.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.controller.PersonsController;
import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.service.PersonsService;

@WebMvcTest(PersonsController.class)
@ExtendWith(MockitoExtension.class)
public class PersonsControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    @Autowired
    private PersonsService personsService;

    @Test
    @DisplayName("Test la demande de la liste persons")
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

        when(personsService.getListPersons()).thenReturn(listPersons); // lorsque le service est appelé, il renvoie la
                                                                       // nouvelle liste

        // WHEN
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk()); // Execute la demande Get /persons

        // THEN
        verify(personsService, times(1)).getListPersons(); // verifie que le service persons est appelé

    }

    @DisplayName("Test la demande d'ajout d'une nouvelle personne")
    public void addPersonList() throws Exception {

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
        when(personsService.addNewPersonToList(any(Persons.class))).thenReturn(listPersons);

        // WHEN
        mockMvc.perform(post("/person").content("{\"firstName\\\":\\\"monPrenom\\\", \\\"lastName\\\":\\\"monNom\\\","
                + " \\\"address\\\":\\\"8 MaRue\\\", \\\"city\\\":\\\"MaVille\\\", \\\"zip\\\":\\\"88888\\\", \\\"phone\\\":\\\"0600000000\\\", \\\"email\\\":\\\"monemail@gmail.com\\\" }\")")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()); // Execute la commande POST
                                                                                      // /person

        // THEN
        verify(personsService, times(1)).addNewPersonToList(any(Persons.class));

    }
}
