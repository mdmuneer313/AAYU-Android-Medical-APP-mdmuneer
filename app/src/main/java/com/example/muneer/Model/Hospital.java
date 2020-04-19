package com.example.muneer.Model;

public class Hospital {
    private String hprating;
    private String address;
    private String city;
    private String hpname;

    public Hospital(String hprating, String address, String city, String hpname) {
        this.hprating = hprating;
        this.address = address;
        this.city = city;
        this.hpname = hpname;
    }

    public Hospital() {

    }
    public String getHprating() {
        return hprating;
    }

    public void setHprating(String Hprating) {
        this.hprating = Hprating;
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
        this.city =city;
    }

    public String getHpname() {
        return hpname;
    }

    public void setHpname(String hpname) {
        this.hpname = hpname;
    }

}
