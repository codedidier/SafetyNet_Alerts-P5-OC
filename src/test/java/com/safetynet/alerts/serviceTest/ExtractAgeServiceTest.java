package com.safetynet.alerts.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.safetynet.alerts.service.ExtractAge;
import com.safetynet.alerts.service.MedicalrecordsServiceInterface;

public class ExtractAgeServiceTest {

    MedicalrecordsServiceInterface medicalrecordsServiceInterface;

    private ExtractAge extractAge = new ExtractAge();

    @Test
    @DisplayName("Test pour calculer l'âge d'une personne à partir de sa date de naissance")
    public void extractAgeBirthDate() {

        // GIVEN:
        String birthdateChild = "01/01/2010";
        String birthdateAdult = "02/02/1970";

        // WHEN
        extractAge.calculateAge(birthdateChild);
        extractAge.calculateAge(birthdateAdult);
        long children = extractAge.getChildren();
        long adults = extractAge.getAdults();

        // THEN
        assertEquals(children, 1);
        assertEquals(adults, 1);

    }

    @Test
    @DisplayName("Test pour calculer l'âge d'un enfant avec la date de naissance")
    public void extractAgeChildBirthDate() {

        // GIVEN:
        String birthdateChild = "01/01/2011";

        // WHEN
        extractAge.calculateAge(birthdateChild);
        long children = extractAge.getAge();

        // THEN
        assertEquals(children, 11);
    }

    @Test
    @DisplayName("Test pour calculer l'âge d'un adult avec la date de naissance")
    public void extractAgeAdultBirthDate() {

//GIVEN:
        String birthdateAdult = "02/01/1970";

        // WHEN
        extractAge.calculateAge(birthdateAdult);
        long adults = extractAge.getAge();

        // THEN
        assertEquals(adults, 51);

    }
}
