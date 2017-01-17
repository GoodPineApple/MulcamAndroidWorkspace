package com.example.taemi.test11_callbook_pineapple.vo;

/**
 * Created by taemi on 2017-01-17.
 */

public class Person {
    private String contactName;
    private String phoneNum;

    public Person(){}

    public Person(String contactName, String phoneNum) {
        this.contactName = contactName;
        this.phoneNum = phoneNum;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "contactName='" + contactName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
