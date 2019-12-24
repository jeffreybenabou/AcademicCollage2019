package com.jeffrey.academiccollage.basicPrograming;

public class Person {
    private String name;
    private String phoneNumber;
    private int imageId;
    private String moneyInBank;

    public Person(String name, String phoneNumber, int imageId, String moneyInBank) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageId = imageId;
        this.moneyInBank = moneyInBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMoneyInBank() {
        return moneyInBank;
    }

    public void setMoneyInBank(String moneyInBank) {
        this.moneyInBank = moneyInBank;
    }
}
