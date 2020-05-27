package com.example.muneer.Model;

public class Aid {
    private  String diseasname;
    private String drugname;
    private  String descripition;
    private  String hints;

    public Aid(String diseasname, String drugname, String descripition, String hints) {
        this.diseasname = diseasname;
        this.drugname = drugname;
        this.descripition = descripition;
        this.hints = hints;
    }

    public Aid() {
        super();
    }

    public String getDiseasname() {
        return diseasname;
    }

    public void setDiseasname(String diseasname) {
        this.diseasname = diseasname;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }
}
