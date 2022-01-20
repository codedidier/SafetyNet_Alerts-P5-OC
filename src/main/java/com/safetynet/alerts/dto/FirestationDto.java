package com.safetynet.alerts.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynet.alerts.model.Persons;

public class FirestationDto {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    @JsonIgnoreProperties({ "zip", "city", "email" })
    private List<Persons> listPersonsStation;
    private long adults;
    private long children;

    public FirestationDto(String firstName, String lastName, String address, String phone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;

    }

    public FirestationDto(List<Persons> listPersonsStation, long adults, long children) {

        this.listPersonsStation = listPersonsStation;
        this.adults = adults;
        this.children = children;

    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getPhone() {

        return phone;
    }

    public List<Persons> getListPersonsStation() {

        return listPersonsStation;
    }

    @Override
    public String toString() {

        return " [ PersonsByFirestation=" + listPersonsStation.toString() + " adults=" + adults + ", children="
                + children + "]";
    }
}
