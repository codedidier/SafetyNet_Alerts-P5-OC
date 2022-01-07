package com.safetynet.alerts.model;

import lombok.Data;

@Data
public class Persons {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private int zip;
    private String phone;
    private String email;
    private Firestations station;
    private Medicalrecords medicalrecords;

    public Persons() {

    }

    public Persons(String firstName, String lastName, String address, String city, int zip, String phone, String email,
            Firestations station, Medicalrecords medicalrecords) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.station = station;
        this.medicalrecords = medicalrecords;

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

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
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

    public void setStation(Firestations station) {
        this.station = station;
    }

    public Firestations getStation() {
        return station;
    }

    public Medicalrecords getMedicalRecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(Medicalrecords medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public void updatepersonsexceptFirstNameLastName(String address, String city, int zip, String phone, String email,
            Firestations station, Medicalrecords medicalRecords) {
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.station = station;
        this.medicalrecords = medicalRecords;
    }

    @Override
    public String toString() {
        return "{" +
                " lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", medicalRecords='" + medicalrecords + '\'' +
                ", station='" + station + '\'' +
                '}';
    }

}