package com.safetynet.alerts.dto;

import java.util.List;

public class FloodDto {

    private String lastName;
    private final String phone;
    private int age;
    private final List<String> medications;
    private final List<String> allergies;

    public FloodDto(String lastName, List<String> medications, List<String> allergies, String phone, int age) {

        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.medications = medications;
        this.allergies = allergies;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPhone() {

        return phone;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public List<String> getMedications() {

        return medications;
    }

    public List<String> getAllergies() {

        return allergies;
    }

    @Override
    public String toString() {

        return "Flood [" + getLastName() + ", " + getPhone() + ", " + getAge() + ", " + getMedications() + ", "
                + getAllergies() + "]";
    }
}
