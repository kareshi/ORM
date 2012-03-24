package com.ivan.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "phone")
public class Phone {

    private long phoneId;
    private String phoneNumber;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        //To change body of created methods use File | Settings | File Templates.
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue
    @Column(name = "PHONE_ID")
    public long getPhoneId() {
        return this.phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
     }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
