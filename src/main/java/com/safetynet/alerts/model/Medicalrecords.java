package com.safetynet.alerts.model;

import java.util.List;

import lombok.Data;

@Data
public class Medicalrecords {

    private String firstName;
    private String lastName;
    private String birthdate;
    private List<String> medications;
    private List<String> allergies;

    public Medicalrecords() {
    }

    public Medicalrecords(String lastName, String firstName, String birthdate, List<String> allergies,
            List<String> medications, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.allergies = allergies;
        this.medications = medications;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void updatemedicalexceptFirstNameLastName(String birthdate, List<String> allergies,
            List<String> medications) {
        this.birthdate = birthdate;
        this.allergies = allergies;
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate=" + birthdate +
                ", allergies='" + allergies + '\'' +
                ", medications='" + medications + '\'' +
                '}';
    }

}
