package com.safetynet.alerts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.Database;
import com.safetynet.alerts.model.Persons;

@Repository
public class PersonsRepository implements PersonsRepositoryInterface {

    private List<Persons> persons;

    @Autowired
    private Database database;

    public PersonsRepository() {
    }

//GET /persons
    @Override
    public List<Persons> getListPersons() {

        return database.getPersons();
    }

//POST /person
    @Override
    public List<Persons> addNewPersonToList(Persons persons) {
        List<Persons> addPersonList = database.getPersons();
        addPersonList.add(persons);
        return addPersonList;
    }

    public List<Persons> getPersons() {
        return persons;
    }

    public void setPersons(List<Persons> persons) {
        this.persons = persons;
    }

//UPDATE /person
    @Override
    public Persons updatePersonToList(String firstNameAndLastName, Persons persons) {

        List<Persons> personUpdate;

        personUpdate = database.getPersons();
        for (Persons update : personUpdate) {
            if (update.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                update.setAddress(persons.getAddress());
                update.setCity(persons.getCity());
                update.setZip(persons.getZip());
                update.setPhone(persons.getPhone());
                update.setEmail(persons.getEmail());
                return update;
            }
        }
        return null;
    }

//DELETE /person
    @Override
    public void deletePersonToList(String firstNameAndLastName) {

        List<Persons> deletePerson = database.getPersons();
        deletePerson.removeIf(persons -> persons.getFirstNameAndLastName().equals(firstNameAndLastName));
    }

//Recherche par adresse pour les URLS
    @Override
    public List<Persons> getByAddress(String address) {

        List<Persons> listPersons = new ArrayList<Persons>();
        for (Persons persons : database.getPersons()) {
            if (persons.getAddress().equals(address)) {
                listPersons.add(persons);
            }
        }
        return listPersons;
    }

//Recherche par nom pour les URLS
    @Override
    public List<Persons> getByLastName(String lastName) {

        List<Persons> listPersons = new ArrayList<Persons>();
        for (Persons persons : database.getPersons()) {
            if (persons.getLastName().equals(lastName)) {
                listPersons.add(persons);
            }
        }
        return listPersons;

    }

//Recherche par prenom et nom pour les URLS
    @Override
    public List<Persons> getByFirstNameAndLastName(String firstName, String lastName) {

        List<Persons> listPersons = new ArrayList<Persons>();
        for (Persons persons : database.getPersons()) {
            if (persons.getFirstName().equals(firstName) && (persons.getLastName().equals(lastName))) {
                listPersons.add(persons);
            }
        }
        return listPersons;
    }

//Recherche par EMAIL ville pour les URLS
    @Override
    public List<Persons> getEmailByCity(String city) {

        List<Persons> listPersons = new ArrayList<>();
        for (Persons persons : database.getPersons()) {
            if (persons.getCity().equals(city)) {
                listPersons.add(persons);
            }
        }
        return listPersons;
    }

}