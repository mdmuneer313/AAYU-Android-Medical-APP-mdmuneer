package com.example.muneer.Model;

public class Hospital {
    private String hprating;
    private String address;
    private String city;
    private String hpname;
    private String blood;
    private String cancer;
    private String ear;
    private String eyes;
    private String heart;
    private String kidney;
    private String contact_No;


    public Hospital(String hprating, String address, String city, String hpname, String blood, String cancer, String ear, String eyes, String heart, String kidney, String contact_No) {
        this.hprating = hprating;
        this.address = address;
        this.city = city;
        this.hpname = hpname;
        this.blood = blood;
        this.cancer = cancer;
        this.ear = ear;
        this.eyes = eyes;
        this.heart = heart;
        this.kidney = kidney;
        this.contact_No = contact_No;
    }

    public String getHprating() {
        return hprating;
    }

    public void setHprating(String hprating) {
        this.hprating = hprating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHpname() {
        return hpname;
    }

    public void setHpname(String hpname) {
        this.hpname = hpname;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getContact_No() {
        return contact_No;
    }

    public void setContact_No(String contact_No) {
        this.contact_No = contact_No;
    }

    public Hospital() {
        super();

    }
}
