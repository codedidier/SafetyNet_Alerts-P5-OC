package com.safetynet.alerts.dto;

import java.util.List;

public class PhoneAlertDto {

    private final List<String> listPhonesCity;

    public PhoneAlertDto(List<String> listPhonesCity) {

        this.listPhonesCity = listPhonesCity;
    }

    public List<String> getListPhonesCity() {

        return listPhonesCity;
    }

}
