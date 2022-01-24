package com.safetynet.alerts.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynet.alerts.model.Persons;

public class FirestationsPersonsDto {

    @JsonIgnoreProperties({ "zip", "city", "email" })
    private List<Persons> listPersonsStation;
    private long adults;
    private long children;

    public FirestationsPersonsDto(List<Persons> listPersonsStation, long adults, long children) {

        this.listPersonsStation = listPersonsStation;
        this.adults = adults;
        this.children = children;

    }

    public FirestationsPersonsDto() {

    }

    public List<Persons> getListPersonsStation() {

        return listPersonsStation;
    }

    public long getAdults() {
        return adults;
    }

    public void setAdults(long adults) {
        this.adults = adults;
    }

    public long getChildren() {
        return children;
    }

    public void setChildren(long children) {
        this.children = children;
    }

    @Override
    public String toString() {

        return " [ PersonsByFirestation=" + listPersonsStation.toString() + " adults=" + adults + ", children="
                + children + "]";
    }
}
