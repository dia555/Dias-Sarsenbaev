package com.company;

public class Doctor {
    //private variables
    private int idEmployee;
    private String firstNameDoctor;
    private String lastNameDoctor;
    private int costPerVisit;
    private String qualification;

    //constructor
    public Doctor(int idEmployee, String firstNameDoctor, String lastNameDoctor, int costPerVisit, String qualification){
        this.idEmployee = idEmployee;
        this.firstNameDoctor = firstNameDoctor;
        this.lastNameDoctor = lastNameDoctor;
        this.costPerVisit = costPerVisit;
        this.qualification = qualification;
    }

    public Doctor(){}

    //creating methods for Database
    public String createTable(){
        return "CREATE TABLE Doctor " +
                "(idDoctor decimal primary key, " +
                "firstNameDoctor char(14), " +
                "lastNameDoctor char(14), " +
                "costPerVisit integer," +
                "qualification varchar(32))";
    }
    public String addInformation(){
        return "INSERT INTO Doctor(idDoctor, firstNameDoctor, lastNameDoctor, costPerVisit, qualification) " +
                "VALUES (1,'Nursultan', 'Zhuldizbekuli', 2000,'Psychologist'),"  +
                "(2, 'Dias', 'Sarsenbaev', 5000,'Allergist'), " +
                "(3, 'Yerkezhan', 'Nurbazarova', 8000,'Cardiologist'), " +
                "(4, 'Nurai', 'Utegen', 9000,'Surgeon'), " +
                "(5, 'Batyrbek', 'Baitanatov', 5000,'Dermatologist') ";
    }

    //encapsulation
    public void setCostPerVisit(int costPerVisit) {
        this.costPerVisit = costPerVisit;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstNameDoctor() {
        return firstNameDoctor;
    }

    public void setFirstNameDoctor(String firstNameDoctor) {
        this.firstNameDoctor = firstNameDoctor;
    }

    public String getLastNameDoctor() {
        return lastNameDoctor;
    }

    public int getCostPerVisit() {
        return costPerVisit;
    }

    public void setLastNameDoctor(String lastNameDoctor) {
        this.lastNameDoctor = lastNameDoctor;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    //polymorphism
    @Override
    public String toString(){
        return "Id: "+idEmployee+", First name: "+firstNameDoctor+", Last name: "+lastNameDoctor+", Cost per visit: "+costPerVisit+", Qualification: "+qualification;
    }

}
