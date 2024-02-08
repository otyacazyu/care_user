package com.otya.care.user;

import java.util.UUID;

public class CareEntity {
    private UUID id;
    private  String name;
    private String gender;
    private int age;
    private String address;
    private String care_needs;

    public CareEntity(UUID id, String name, String gender, int age, String address, String care_needs) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.care_needs = care_needs;
    }

    public CareEntity() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getCare_needs() {
        return care_needs;
    }

    public void setCare_needs(String care_needs) {
        this.care_needs = care_needs;
    }
}
