package com.company;

public class Patient extends Doctor implements CostCalculator{
    //private variables
    private int idPatient;
    private String firstNamePatient;
    private String lastNamePatient;
    private String diagnosis;
    private int visits;

    //constructor
    public Patient(){}
    public Patient(int idEmployee, String firstNameDoctor, String lastNameDoctor,String qualification, int costPerVisit, int idPatient, String firstNamePatient, String lastNamePatient, String diagnosis, int visits){
        super(idEmployee, firstNameDoctor, lastNameDoctor, costPerVisit,qualification);
        this.diagnosis = diagnosis;
        this.firstNamePatient = firstNamePatient;
        this.lastNamePatient = lastNamePatient;
        this.idPatient = idPatient;
        this.visits = visits;
    }

    //creating methods for Database
    public String createTable(){
        return "CREATE TABLE Patient " +
                "(idPatient serial primary key, " +
                "firstNamePatient char(14), " +
                "lastNamePatient char(14), " +
                "diagnosis char(24), " +
                "visits integer, " +
                "idDoctor decimal references Doctor(idDoctor))";
    }
    public String addInformation(){
        return "INSERT INTO Patient( firstNamePatient, lastNamePatient, diagnosis, visits, idDoctor) " +
                "VALUES ('Aidar', 'Zhunusoff', 'Nasmork', 15, 2), \n" +
                "('Sultan', 'Danabek', 'Siyp', 24, 2), \n" +
                "('Bakgeldi', 'Alkhabay', 'Bipolar', 14, 1), \n" +
                "('Yagami', 'Ligh', 'Heart attack', 10, 3), \n" +
                "('Adil', 'Tazhi', 'Appendix', 7, 4), \n" +
                "('Bill', 'Gates', 'Tahicardia', 18, 3), \n" +
                "('Mark', 'Zuckerberg', 'Acne', 30, 5), \n" +
                "('Damir','Zhantenov','Agression', 30, 1), \n" +
                "('Aibatov','Ernest','Mambetion', 100, 1), \n" +
                "('Nurali', 'Oryngaliev', 'Acne', 12, 5), \n" +
                "('Dinmukhammed', 'Abdussamat', 'Allergia on cactus', 5, 2), \n" +
                "('Dias', 'Pak', 'Infarct', 1, 3), \n" +
                "('Yerassyl', 'Amanzhol', 'Gemoroi', 1, 4), \n" +
                "('Merekeev', 'Abilkaiyr', 'Broken Nose', 1, 4), \n" +
                "('Yeldos', 'Tazhenov', '5 Degree Burn', 1, 5)";
    }
    //encapsulation
    public int getIdPatient() {
        return idPatient;
    }

    public int getVisits() {
        return visits;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getFirstNamePatient() {
        return firstNamePatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setFirstNamePatient(String firstNamePatient) {
        this.firstNamePatient = firstNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    //polymorphism
    @Override
    public String toString(){
        return "Id: "+idPatient+", First name: "+firstNamePatient+", Last name: "+lastNamePatient+", Diagnosis: "+diagnosis+", Visits: "+visits;
    }
}
