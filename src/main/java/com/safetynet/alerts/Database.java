package com.safetynet.alerts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.model.Persons;

import lombok.Data;

@Data
@Component
public class Database {

    private List<Persons> persons;
    private List<Firestations> firestations;
    private List<Medicalrecords> medicalrecords;

    @PostConstruct
    public void initDatabase() throws IOException {

        Database database = new Database();
        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/data.json"));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            database = objectMapper.readValue(jsonData, Database.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.persons = database.getPersons();
        this.medicalrecords = database.getMedicalrecords();
        this.firestations = database.getFirestations();

    }

    public List<Firestations> getFirestations() {

        return firestations;
    }

    public List<Medicalrecords> getMedicalrecords() {

        return medicalrecords;
    }

    public List<Persons> getPersons() {

        return persons;
    }

    @Override
    public String toString() {

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Persons=" + "\n" + getPersons() + "\n");
        stringbuilder.append("Medicalrecords=" + "\n" + getMedicalrecords() + "\n");
        stringbuilder.append("Firestations=" + "\n" + getFirestations() + "\n");

        return stringbuilder.toString();
    }

}