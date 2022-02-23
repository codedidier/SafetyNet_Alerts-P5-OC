package com.safetynet.alerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Persons {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    @JsonIgnore
    private Medicalrecords medicalrecords;
    @JsonIgnore
    int age;
    @JsonIgnore
    private Firestations firestations;
    @JsonIgnore
    private String firstNameAndLastName;

    public Persons() {

    }

    public Persons(String firstName, String lastName, String address, String city, String zip, String phone,
            String email, Firestations firestations, int age, Medicalrecords medicalrecords,
            String firstNameAndLastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.medicalrecords = medicalrecords;
        this.firestations = firestations;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public Medicalrecords getMedicalRecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(Medicalrecords medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public Firestations getFirestations() {

        return firestations;
    }

    public void setFirestations(Firestations firestations) {

        this.firestations = firestations;
    }

    public String getFirstNameAndLastName() {

        return firstName + lastName;

    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getCity() + ", " + getZip() + ", "
                + getPhone() + ", " + getEmail() + "\n";
    }

}