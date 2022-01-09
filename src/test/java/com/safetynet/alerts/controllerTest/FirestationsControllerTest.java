package com.safetynet.alerts.controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.safetynet.alerts.model.Firestations;

@WebMvcTest
public class FirestationsControllerTest {

    @DisplayName("Test return status for getListFirestations request")

    @Test
    public void getListFirestations() throws Exception {

        // GIVEN
        Firestations firestations = new Firestations(); // creation new object Firestations
        firestations.setAddress("1800 MaRue"); // définir l'adresse dans l'object
        firestations.setStation(8); // définir le numéro de la station Firestations
        List<Firestations> firestationsList = new ArrayList<>(); // creation new List de Firestations
        firestationsList.add(firestations); // ajouter l'objet Firestations à la liste des Firestations

        firestationsList.equals((toString("1800 MaRue" + "8")));

    }

    private Object toString(String string) {
        // TODO Auto-generated method stub
        return null;
    }

}
