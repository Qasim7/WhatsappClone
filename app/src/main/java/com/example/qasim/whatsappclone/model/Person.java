package com.example.qasim.whatsappclone.model;

public class Person {
    private int ID;
    private String name;
    private int number;
    private String email;
    private String zipcode;


    public Person(int ID, String name, int number, String email, String zipcode) {
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.email = email;
        this.zipcode = zipcode;
    }


    public Person(String name, int number, String email, String zipcode) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.zipcode = zipcode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
