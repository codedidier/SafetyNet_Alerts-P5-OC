package com.safetynet.alerts.model;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Firestations {

    @Autowired
    private String address;
    private int station;

    public Firestations() {
    }

    public Firestations(String address, int station) {
        this.address = address;
        this.station = station;
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

    @Override
    public String toString() {
        return "Station { " + " address='" + address + '\'' +
                ", station='" + station + '\'' +
                '}';
    }

}