package com.safetynet.alerts.repository;

import java.util.List;

import com.safetynet.alerts.model.Persons;

public interface PersonsRepositoryInterface {

    List<Persons> getListPersons();

    List<Persons> addNewPersonToList(Persons persons);

}
