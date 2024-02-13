package com.otya.care.user;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CareForm {

    private String name;
    private String gender;
    private  int age;
    private String address;
    private  String careNeeds;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CareForm(String name, String gender, int age, String address, String careNeeds) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.careNeeds = careNeeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCareNeeds() {
        return careNeeds;
    }

    public void setCareNeeds(String careNeeds) {
        this.careNeeds = careNeeds;
    }
}
