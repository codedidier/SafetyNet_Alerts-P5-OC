package com.safetynet.alerts.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Firestations {

    @Autowired
    private String address;
    private int station;
    @JsonIgnore
    private List<Persons> persons;

    public Firestations() {
    }

    public Firestations(String address, int station, List<Persons> persons) {
        this.address = address;
        this.station = station;
        this.persons = persons;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public List<Persons> getPersons() {
        return persons;
    }

    public void setPersons(List<Persons> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return getAddress() + ", " + getStation() + "\n";
    }

    public Firestations size() {

        return null;
    }

}