package com.safetynet.alerts;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    public Database() {
        super();
    }

    @JsonCreator
    Database(@JsonProperty("persons") final List<Persons> persons,
            @JsonProperty("firestations") final List<Firestations> firestations,
            @JsonProperty("medicalrecords") final List<Medicalrecords> medicalrecords) {
        this.persons = persons;
        this.firestations = firestations;
        this.medicalrecords = medicalrecords;
    }

}