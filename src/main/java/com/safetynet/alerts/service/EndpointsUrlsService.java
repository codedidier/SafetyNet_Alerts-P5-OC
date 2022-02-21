package com.safetynet.alerts.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.Exception.NoFoundException;
import com.safetynet.alerts.ageCalculator.ExtractAge;
import com.safetynet.alerts.dto.ChildAlertDto;
import com.safetynet.alerts.dto.ChildAlertWithAgeDto;
import com.safetynet.alerts.dto.CommunityEmailDto;
import com.safetynet.alerts.dto.FireAddressDto;
import com.safetynet.alerts.dto.FireDto;
import com.safetynet.alerts.dto.FirestationsPersonsDto;
import com.safetynet.alerts.dto.FloodDto;
import com.safetynet.alerts.dto.PersonInfoDto;
import com.safetynet.alerts.dto.PhoneAlertDto;
import com.safetynet.alerts.model.Firestations;
import com.safetynet.alerts.model.Medicalrecords;
import com.safetynet.alerts.model.Persons;
import com.safetynet.alerts.repositoryInterface.FirestationsRepositoryInterface;
import com.safetynet.alerts.repositoryInterface.MedicalrecordsRepositoryInterface;
import com.safetynet.alerts.repositoryInterface.PersonsRepositoryInterface;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EndpointsUrlsService {

    @Autowired
    PersonsRepositoryInterface personsRepositoryInterface;
    @Autowired
    FirestationsRepositoryInterface firestationsRepositoryInterface;
    @Autowired
    MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface;

    public EndpointsUrlsService(PersonsRepositoryInterface personsRepositoryInterface,
            FirestationsRepositoryInterface firestationsRepositoryInterface,
            MedicalrecordsRepositoryInterface medicalrecordsRepositoryInterface) {

        this.personsRepositoryInterface = personsRepositoryInterface;
        this.firestationsRepositoryInterface = firestationsRepositoryInterface;
        this.medicalrecordsRepositoryInterface = medicalrecordsRepositoryInterface;
    }

    // URL firestation
    public FirestationsPersonsDto listPersonsByStation(int stationNumber) throws ParseException {

        ExtractAge extractAge = new ExtractAge();
        List<Persons> listPersonsStation = new ArrayList<Persons>();
        for (Firestations firestation1 : firestationsRepositoryInterface.getAddressByStation(stationNumber)) {
            List<Persons> listPerson1 = personsRepositoryInterface.getByAddress(firestation1.getAddress());
            listPersonsStation.addAll(listPerson1);

            for (Persons persons : listPerson1) {
                Medicalrecords medicalrecords = medicalrecordsRepositoryInterface
                        .getByFirstName(persons.getFirstName());
                extractAge.calculateAge(medicalrecords.getBirthdate());
            }
        }
        log.info("listPersonsByStation OK :" + stationNumber);
        return new FirestationsPersonsDto(listPersonsStation, extractAge.getAdults(), extractAge.getChildren());
    }

    // URL childAlert
    public ChildAlertDto listChildByAddress(String address) throws ParseException {

        List<Persons> listPersonsByAddress = personsRepositoryInterface.getByAddress(address);
        ChildAlertDto childAlertDto = new ChildAlertDto();
        List<ChildAlertWithAgeDto> childList = new ArrayList<>();
        List<ChildAlertWithAgeDto> adultsList = new ArrayList<>();

        ExtractAge extractAge = new ExtractAge();
        List<Medicalrecords> listMedicalrecords = new ArrayList<Medicalrecords>();
        for (Persons persons : listPersonsByAddress) {
            Medicalrecords medicalrecords = medicalrecordsRepositoryInterface.getByFirstName(persons.getFirstName());
            listMedicalrecords.add(medicalrecords);
            extractAge.calculateAge(medicalrecords.getBirthdate());

            ChildAlertWithAgeDto childAlertWithAgeDto = new ChildAlertWithAgeDto(persons.getFirstName(),
                    persons.getLastName(),
                    extractAge.getAge());
            if (extractAge.getAge() == 0) {
                return null;
            } else {
                if (childAlertWithAgeDto.getAge() < 18) {
                    childList.add(childAlertWithAgeDto);
                } else {
                    adultsList.add(childAlertWithAgeDto);
                }
            }

        }
        childAlertDto.setChildren(childList);
        childAlertDto.setAdults(adultsList);
        log.info("listChildByAddress OK :" + address);
        return childAlertDto;
    }

    // URL phoneAlert
    public PhoneAlertDto listPhoneByFirestation(int firestation) {

        List<Persons> listPersons = new ArrayList<>();
        List<String> listPhones = new ArrayList<>();
        for (Firestations firestation2 : firestationsRepositoryInterface.getAddressByStation(firestation)) {
            listPersons.addAll(personsRepositoryInterface.getByAddress(firestation2.getAddress()));
        }
        for (Persons persons : listPersons) {
            listPhones.add(persons.getPhone());
        }
        log.info("listPhoneByFirestation OK :" + firestation);
        return new PhoneAlertDto(listPhones);
    }

    // URL fire
    public FireAddressDto listPersonsByAddressAndStationNumber(String address) throws ParseException {

        Firestations firestationNumber = firestationsRepositoryInterface.getById(address);

        if (firestationNumber != null) {
            List<Persons> listPersons3 = personsRepositoryInterface.getByAddress(firestationNumber.getAddress());
            List<Persons> listPersons = new ArrayList<>(listPersons3);
            List<FireDto> listPersonsByAddress = new ArrayList<>();

            ExtractAge extractAge = new ExtractAge();
            for (Persons persons : listPersons) {
                Medicalrecords medicalrecords = medicalrecordsRepositoryInterface
                        .getByFirstName(persons.getFirstName());
                extractAge.calculateAge(medicalrecords.getBirthdate());
                listPersonsByAddress.add(new FireDto(persons.getLastName(), persons.getPhone(), extractAge.getAge(),
                        medicalrecords.getMedications(),
                        medicalrecords.getAllergies()));

            }
            log.info("listPersonsByAddressAndStationNumber OK :" + address);
            return new FireAddressDto(firestationNumber, listPersonsByAddress);
        } else {
            throw new NoFoundException("listPersonsByAddressAndStationNumber Echec :" + address);
        }
    }

    // URL flood
    public List<FloodDto> listHomeByStation(List<Integer> stations) throws ParseException {

        List<FloodDto> floodDto = new ArrayList<>();
        ExtractAge extractAge = new ExtractAge();
        List<Persons> listPersons = new ArrayList<>();

        for (Integer station : stations) {

            for (Firestations firestations : firestationsRepositoryInterface.getAddressByStation(station)) {
                List<Persons> listPersons2 = personsRepositoryInterface.getByAddress(firestations.getAddress());
                listPersons.addAll(listPersons2);
            }

            List<Medicalrecords> listMedical = new ArrayList<>();
            for (Persons persons : listPersons) {
                Medicalrecords medicalrecords = medicalrecordsRepositoryInterface
                        .getByFirstName(persons.getFirstName());
                listMedical.add(medicalrecords);
                extractAge.calculateAge(medicalrecords.getBirthdate());

                floodDto.add(new FloodDto(persons.getLastName(), medicalrecords
                        .getMedications(), medicalrecords.getAllergies(), persons.getPhone(), extractAge.getAge()));
            }
        }
        log.info("listHomeByStation OK :" + stations);
        return floodDto;
    }

    // URL personInfo
    public List<PersonInfoDto> listPersonInfo(String firstName, String lastName) throws ParseException {

        List<Persons> listPersons2 = personsRepositoryInterface.getByLastName(lastName);
        List<Persons> listPersons = new ArrayList<Persons>(listPersons2);
        List<PersonInfoDto> personInfoDtoList = new ArrayList<PersonInfoDto>();

        ExtractAge extractAge = new ExtractAge();
        for (Persons persons : listPersons) {
            Medicalrecords medicalrecords = medicalrecordsRepositoryInterface.getByFirstName(persons.getFirstName());
            extractAge.calculateAge(medicalrecords.getBirthdate());
            personInfoDtoList
                    .add(new PersonInfoDto(persons.getLastName(), persons.getAddress(), extractAge.getAge(), persons
                            .getEmail(), medicalrecords.getMedications(), medicalrecords.getAllergies()));
        }
        log.info("listPersonInfo OK :" + (firstName + lastName));
        return personInfoDtoList;
    }

    // URL communityEmail
    public CommunityEmailDto listEmailsByCity(String city) {

        List<Persons> listPersons = new ArrayList<>();
        List<String> listEmails = new ArrayList<>();
        for (Persons persons : personsRepositoryInterface.getEmailByCity(city)) {
            listPersons.add(persons);
        }
        for (Persons persons : listPersons) {
            listEmails.add(persons.getEmail());
        }
        log.info("listEmailsByCity OK :" + city);
        return new CommunityEmailDto(listEmails);
    }
}
