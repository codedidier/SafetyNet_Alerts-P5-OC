package com.safetynet.alerts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Medicalrecords {

    private String firstName;
    private String lastName;
    private String birthdate;
    private List<String> medications;
    private List<String> allergies;
    @JsonIgnore
    private int age;
    @JsonIgnore
    private String firstNameAndLastName;

    // public Medicalrecords(String lastName, String birthdate, List<String>
    // medications, List<String> allergies) {
    // }

    public Medicalrecords() {
    }

    public Medicalrecords(String firstName, String lastName, String birthdate, List<String> medications,
            List<String> allergies, int age, String firstNameAndLastName) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.allergies = allergies;
        this.medications = medications;
        this.age = age;
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

    public String getFirstNameAndLastName() {

        return firstName + lastName;
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

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getBirthdate() + ", " + getMedications() + ", "
                + getAllergies() + "\n";
    }

}
