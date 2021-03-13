package com.company;

public class Hospital extends Doctor implements CostCalculator{
    //private variables
    private int idHospital;
    private String name;
    private String city;

    //constructor
    public Hospital(){}
    public Hospital(int idEmployee, String firstNameDoctor, String lastNameDoctor, int costPerVisit,String qualification, int idHospital, String name, String city){
        super(idEmployee, firstNameDoctor, lastNameDoctor, costPerVisit,qualification);
        this.city = city;
        this.idHospital = idHospital;
        this.name = name;
    }
    //creating methods for Database
    public String deleteSchema(){
        return "Drop schema public cascade;" +
                "CREATE SCHEMA public";
    }
    public String createTable(){
        return "CREATE TABLE Hospital " +
                "(idHospital decimal primary key, " +
                "name char(32), " +
                "city char(24)," +
                "idDoctor decimal references Doctor(idDoctor))";
    }
    public String addInformation(){
        return "INSERT INTO Hospital(idHospital, name, city,idDoctor) " +
                "VALUES (1, '1st named after Dr. White', 'Chicago',2)," +
                "(2, '5th named after Plutonus', 'Atlanta',5), " +
                "(3, '4th named after Mr. Nobody', 'Texas',3)," +
                "(4,'2nd named after Gerodot','New-York',1)," +
                "(5,'1st named after Gyppokrat','New-York',1)," +
                "(6,'6th named after Lebron','Canada',4)," +
                "(7,'3rd named after Jameson','Atlanta',5)," +
                "(8,'4th named after Putin','Canada',4)," +
                "(9,'5th named after Shaqil','Texas',3)," +
                "(10,'6th named after Eminem','Chicago',2)," +
                "(11,'3rd named after Ilon','Canada',4)";
    }
    //encapsulation
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    //polymorphism
    @Override
    public String toString(){
        return "Id of hospital: "+idHospital+", Name of hospital: "+name+", City of hospital: "+city;
    }
}
