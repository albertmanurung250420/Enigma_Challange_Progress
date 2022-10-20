package com.mandiri.dto;

import java.sql.Date;

public class ArtistsSearchCriteria {
    private final String name;
    private final String birthPlace;
    private final Date startBirthDate;
    private final Date endBirthDate;
    private final String email;
    private final String phone;
    private final String gender;

    public ArtistsSearchCriteria(String name, String birthPlace, Date startBirthDate, Date endBirthDate, String email, String phone, String gender) {
        this.name = name;
        this.birthPlace = birthPlace;
        this.startBirthDate = startBirthDate;
        this.endBirthDate = endBirthDate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Date getStartBirthDate() {
        return startBirthDate;
    }

    public Date getEndBirthDate() {
        return endBirthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }
}
