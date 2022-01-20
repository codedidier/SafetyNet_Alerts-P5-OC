package com.safetynet.alerts.controller;

import java.text.ParseException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.dto.ChildAlertDto;
import com.safetynet.alerts.dto.CommunityEmailDto;
import com.safetynet.alerts.dto.FireAddressDto;
import com.safetynet.alerts.dto.FirestationDto;
import com.safetynet.alerts.dto.FloodDto;
import com.safetynet.alerts.dto.PersonInfoDto;
import com.safetynet.alerts.dto.PhoneAlertDto;
import com.safetynet.alerts.service.EndpointsUrlsService;

@RestController
public class EndpointsUrlsController {

    private static final Logger logger = LogManager.getLogger("EndpointsUrlsController");

    @Autowired
    EndpointsUrlsService endpointsUrlsService;

    // URL firestation
    @GetMapping(value = "/firestation")
    public FirestationDto listPersonsByStation(@RequestParam(value = "stationNumber") int stationNumber)
            throws ParseException {

        logger.info("listPersonsByStation");
        return endpointsUrlsService.listPersonsByStation(stationNumber);
    }

    // URL childAlerts
    @GetMapping(value = "/childAlert")
    public ChildAlertDto listChildByAddress(@RequestParam(value = "address") String address) throws ParseException {

        logger.info("listChildByAddress");
        return endpointsUrlsService.listChildByAddress(address);
    }

    // URL phoneAlert
    @GetMapping(value = "/phoneAlert")
    public PhoneAlertDto listPhoneByFirestation(@RequestParam(value = "firestation") int firestation) {

        logger.info("listPhoneByFirestation");
        return endpointsUrlsService.listPhoneByFirestation(firestation);
    }

    // URL fire
    @GetMapping(value = "/fire")
    public FireAddressDto listPersonsByAddressAndStationNumber(@RequestParam(value = "address") String address)
            throws ParseException {

        logger.info("listPersonsByAddressAndStationNumber");
        return endpointsUrlsService.listPersonsByAddressAndStationNumber(address);
    }

    // URL flood
    @GetMapping(value = "/flood/stations")
    public List<FloodDto> listHomeByStation(@RequestParam(value = "stations") List<Integer> stations)
            throws ParseException {

        logger.info("listFamilyByStation");
        return endpointsUrlsService.listHomeByStation(stations);
    }

    // URL personinfo
    @GetMapping(value = "/personInfo")
    public List<PersonInfoDto> listPersonInfo(@RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) throws ParseException {

        logger.info("listPersonInfo");
        return endpointsUrlsService.listPersonInfo(firstName, lastName);
    }

    // URL communityEmail
    @GetMapping(value = "/communityEmail")
    public CommunityEmailDto listEmailsByCity(@RequestParam(value = "city") String city) {

        logger.info("allEmailsByCity");
        return endpointsUrlsService.listEmailsByCity(city);
    }
}
