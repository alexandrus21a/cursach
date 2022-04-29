package com.ntu.domain;

import java.io.Serializable;
import java.sql.Date;

public class PersonReader implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private Date birthDt;
    private String serialOfPassport;
    private int numOfPassport;
    private String address;

    public PersonReader() {
    }

    public PersonReader(String firstName, String middleName, String lastName, String phone, Date birthDt, String serialOfPassport, int numOfPassport, String address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDt = birthDt;
        this.serialOfPassport = serialOfPassport;
        this.numOfPassport = numOfPassport;
        this.address = address;
    }

    public PersonReader(long id, String firstName, String middleName, String lastName, String phone, Date birthDt, String serialOfPassport, int numOfPassport, String address) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDt = birthDt;
        this.serialOfPassport = serialOfPassport;
        this.numOfPassport = numOfPassport;
        this.address = address;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDt() {
        return this.birthDt;
    }

    public void setBirthDt(Date birthDt) {
        this.birthDt = birthDt;
    }

    public String getSerialOfPassport() {
        return this.serialOfPassport;
    }

    public void setSerialOfPassport(String serialOfPassport) {
        this.serialOfPassport = serialOfPassport;
    }

    public int getNumOfPassport() {
        return this.numOfPassport;
    }

    public void setNumOfPassport(int numOfPassport) {
        this.numOfPassport = numOfPassport;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "PersonReader [id=" + this.id + ", firstName=" + this.firstName + ", middleName=" + this.middleName + ", lastName=" + this.lastName + ", phone=" + this.phone + ", birthDt=" + this.birthDt + ", serialOfPassport=" + this.serialOfPassport + ", numOfPassport=" + this.numOfPassport + ", address=" + this.address + "]";
    }
}
