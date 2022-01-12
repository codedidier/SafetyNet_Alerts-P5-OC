package com.safetynet.alerts.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Firestations;

import lombok.Data;

@Data
@Repository
public class FirestationsRepository implements FirestationsRepositoryInterface {

    @Autowired
    private Database database;

    public Database getDatabase() {

        return database;
    }

    @Override
    public List<Firestations> getListFirestations() {

        return database.getFirestations();
    }
}
