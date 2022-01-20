package com.safetynet.alerts.dto;

import java.util.List;

import com.safetynet.alerts.model.Firestations;

public class FireAddressDto {

    private Firestations firestationNumber;
    private List<FireDto> listPersonsByAddress;

    public FireAddressDto(Firestations firestationNumber, List<FireDto> listPersonsByAddress) {

        this.firestationNumber = firestationNumber;
        this.listPersonsByAddress = listPersonsByAddress;
    }

    public Firestations getFirestationNumber() {

        return firestationNumber;
    }

    public void setFirestationNumber(Firestations firestationNumber) {

        this.firestationNumber = firestationNumber;
    }

    public List<FireDto> getListPersonsByAddress() {

        return listPersonsByAddress;
    }

    public void setListPersonsByAddress(List<FireDto> listPersonsByAddress) {

        this.listPersonsByAddress = listPersonsByAddress;
    }

    @Override
    public String toString() {

        return "PersonFireAddress [firestation=" + getFirestationNumber() + ", personFireAddress="
                + getListPersonsByAddress() + "]";
    }
}
