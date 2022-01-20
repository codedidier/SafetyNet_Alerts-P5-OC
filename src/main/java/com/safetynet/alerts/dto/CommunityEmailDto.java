package com.safetynet.alerts.dto;

import java.util.List;

public class CommunityEmailDto {

    private final List<String> listEmails;

    public CommunityEmailDto(List<String> listEmails) {

        this.listEmails = listEmails;
    }

    public List<String> getListEmails() {

        return listEmails;
    }

    @Override
    public String toString() {

        return "EmailList [" + getListEmails() + "]";
    }
}
