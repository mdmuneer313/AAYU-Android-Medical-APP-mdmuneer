package com.example.muneer.Model;

public class Aid {
    private String DiseasName;
    private String DrugName;
    private String Description;
    private String Hints;

    public Aid(String diseasName, String drugName, String description, String hints) {
        DiseasName = diseasName;
        DrugName = drugName;
        Description = description;
        Hints = hints;
    }

    public String getDiseasName() {
        return DiseasName;
    }

    public void setDiseasName(String diseasName) {
        DiseasName = diseasName;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHints() {
        return Hints;
    }

    public void setHints(String hints) {
        Hints = hints;
    }
}
