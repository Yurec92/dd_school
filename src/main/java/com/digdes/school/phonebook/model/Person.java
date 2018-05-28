package com.digdes.school.phonebook.model;

import com.linuxense.javadbf.DBFRow;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;
import java.util.Date;

public class Person {

    @CsvBindByPosition(position = 0)
    private Long id;
    @CsvBindByPosition(position = 1)
    private String firstName;
    @CsvBindByPosition(position = 2)
    private String lastName;
    @CsvBindByPosition(position = 3)
    private String middleName;
    @CsvBindByPosition(position = 4)
    @CsvDate("dd.MM.yyyy")
    private Date dateBirth;
    @CsvBindByPosition(position = 5)
    private String phoneNumber;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String middleName, Date dateBirth, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public static class Cols {
        public static final String ID = "PERSON_ID";
        public static final String FIRST_NAME = "FIRST_NAME";
        public static final String LAST_NAME = "LAST_NAME";
        public static final String MIDDLE_NAME = "MID_NAME";
        public static final String DATE_BIRTH = "DATE_BIRTH";
        public static final String PHONE_NUMBER = "PHONE_NUM";
    }
}
