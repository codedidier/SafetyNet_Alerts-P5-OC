package com.safetynet.alerts.ageCalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.safetynet.alerts.ageCalculator.ExtractAge;
import com.safetynet.alerts.serviceInterface.MedicalrecordsServiceInterface;

public class ExtractAgeServiceTest {

    MedicalrecordsServiceInterface medicalrecordsServiceInterface;

    private ExtractAge extractAge = new ExtractAge();

    private long adults = 0;
    private long children = 0;

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
        assertEquals(adults, 52);

    }

    @Test
    @DisplayName(value = "setChildren")
    public void setChildren() {

//GIVEN:
        ExtractAge birthdateChild = new ExtractAge();
        birthdateChild.setChildren(children);
        // WHEN
        birthdateChild.calculateAge("01/01/2011");
        long children = extractAge.getAge();

        // THEN
        assertEquals(0, children);

    }

    @Test
    @DisplayName(value = "setAdults")
    public void setAdults() {

//GIVEN:
        ExtractAge birthdateAdults = new ExtractAge();
        birthdateAdults.setAdults(adults);
        int age = 22;
        // WHEN
        // birthdateAdults.calculateAge("01/01/2000");
        // long adults = extractAge.getAge();
        birthdateAdults.setAge(22);
        // THEN
        assertEquals(22, age);
    }

    @Test
    @DisplayName("getListAgeCalculate")
    public void getlistAgeCalculate() {
        ExtractAge AgeCalculate = new ExtractAge();

        AgeCalculate.setAdults(adults);
        adults = 22;
        AgeCalculate.setChildren(children);
        children = 11;

        AgeCalculate.getListAgeCalculate();

    }
}
