package com.example.muneer.Model;

public class Aid {
    private String diseasname;
    private String drugname;
    private String description;
    private String hints;

    public Aid(String diseasname, String drugname, String description, String hints) {
        this.diseasname = diseasname;
        this.drugname = drugname;
        this.description = description;
        this.hints = hints;
    }
    public Aid() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }
}
