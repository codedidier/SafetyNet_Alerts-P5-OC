package com.safetynet.alerts.dto;

import java.util.List;

public class ChildAlertDto {

    private List<ChildAlertWithAgeDto> children;
    private List<ChildAlertWithAgeDto> adults;

    public List<ChildAlertWithAgeDto> getChildren() {

        return children;
    }

    public void setChildren(List<ChildAlertWithAgeDto> children) {

        this.children = children;
    }

    public List<ChildAlertWithAgeDto> getAdults() {

        return adults;
    }

    public void setAdults(List<ChildAlertWithAgeDto> adults) {

        this.adults = adults;
    }

    @Override
    public String toString() {

        return "ChildByAddressDto [children=" + getChildren() + ", adults=" + getAdults() + "]";
    }
}
