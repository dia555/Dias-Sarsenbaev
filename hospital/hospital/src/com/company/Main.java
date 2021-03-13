package com.company;

//importing libraries
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //creating connection
        Connection c = null;
        Statement stmt = null;
        try {
            //load driver's class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            //establish the connection
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "8778");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Database opened successfully ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            //execute queries with the database using object of statement
            stmt = c.createStatement();
            //creating elements of class Hospital
            Hospital hospitalInfo=new Hospital();
            //creating elements of class Doctor
            Doctor doctorInfo=new Doctor();
            //creating elements of class Patient
            Patient patientInfo=new Patient();
            //dropping schema and creating schema
            stmt.executeUpdate(hospitalInfo.deleteSchema());
            //creating table Doctor
            stmt.executeUpdate(doctorInfo.createTable());
            //creating table Hospital
            stmt.executeUpdate(hospitalInfo.createTable());
            //creating table Patient
            stmt.executeUpdate(patientInfo.createTable());
            //inserting information into Doctor table
            stmt.executeUpdate(doctorInfo.addInformation());
            //inserting information into Hospital table
            stmt.executeUpdate(hospitalInfo.addInformation());
            //inserting information into Patient table
            stmt.executeUpdate(patientInfo.addInformation());
            Statement finalStmt = stmt;
            //execute query to the database
            System.out.println("There are information about doctors: ");
            ResultSet resultSet = finalStmt.executeQuery(
                    "SELECT * from Doctor ");
            //processing the result
            while(resultSet.next()) {
                int idDoctor = resultSet.getInt("idDoctor");
                String firstNameDoctor = resultSet.getString("firstNameDoctor");
                String lastNameDoctor = resultSet.getString("lastNameDoctor");
                int costPerVisit = resultSet.getInt("costPerVisit");
                String qualification = resultSet.getString("qualification");
                Doctor doctor = new Doctor(idDoctor, firstNameDoctor, lastNameDoctor, costPerVisit, qualification);
                System.out.println(doctor.toString());
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Input id of doctor and I will show you where this doctor works: ");
            Scanner scanner = new Scanner(System.in);
            String idDoc = scanner.nextLine();
            //execute query to the database
            resultSet = finalStmt.executeQuery(
                    "SELECT name,idHospital,city,Doctor.idDoctor, Doctor.firstNameDoctor, Doctor.lastNameDoctor, Doctor.costPerVisit, Doctor.qualification from Hospital " +
                            "INNER JOIN Doctor ON Doctor.idDoctor = Hospital.idDoctor " +
                            "WHERE Doctor.idDoctor = "+idDoc);
            //processing the result
            while(resultSet.next()) {
                int idDoctor = resultSet.getInt("idDoctor");
                String firstNameDoctor = resultSet.getString("firstNameDoctor");
                String lastNameDoctor = resultSet.getString("lastNameDoctor");
                int costPerVisit = resultSet.getInt("costPerVisit");
                String qualification = resultSet.getString("qualification");
                int idHospital=resultSet.getInt("idHospital");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                Hospital hospital = new Hospital(idHospital,name,city,idHospital,qualification,idHospital,name,city);
                Doctor doctor = new Doctor(idDoctor, firstNameDoctor, lastNameDoctor, costPerVisit, qualification);
                System.out.println(doctor.toString());
                System.out.println(hospital.toString());
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            }
            System.out.println("To make an appointment with a doctor you need to input your first name: ");
            String fname = scanner.nextLine();
            System.out.println("What is your last name: ");
            String lname= scanner.nextLine();
            System.out.println("What is  your diagnosis: ");
            String diagnos=scanner.nextLine();
            System.out.println("How many visits do you need: ");
            int visit= scanner.nextInt();
            System.out.println("Input id of your doctor: ");
            int idDoctor= scanner.nextInt();
            //Adding information about patient to Patient table
            String sql="INSERT INTO Patient( firstNamePatient, lastNamePatient, diagnosis, visits, idDoctor) " +
                    "VALUES ('"+fname+"','" +lname+"','"+diagnos+"',"+visit+","+idDoctor+")";
            stmt.executeUpdate(sql);
            System.out.println("You have signed up successfully!");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("There are patients of your doctor: ");
            System.out.println();
            //execute query to the database
            resultSet = finalStmt.executeQuery(
                    "SELECT costPerVisit, idPatient, firstNamePatient, lastNamePatient, diagnosis, visits, Doctor.qualification FROM DOCTOR " +
                            "INNER JOIN Patient ON Doctor.idDoctor = Patient.idDoctor " +
                            "WHERE Doctor.idDoctor = "+idDoctor);
            //processing the result
            while(resultSet.next()){
                int costPerVisit = resultSet.getInt("costPerVisit");
                int idPatient = resultSet.getInt("idPatient");
                String firstNamePatient = resultSet.getString("firstNamePatient");
                String lastNamePatient = resultSet.getString("lastNamePatient");
                String qualification = resultSet.getString("qualification");
                String diagnosis = resultSet.getString("diagnosis");
                int visits = resultSet.getInt("visits");
                Patient patient = new Patient(idPatient,firstNamePatient,lastNamePatient,qualification,costPerVisit,idPatient,firstNamePatient, lastNamePatient, diagnosis, visits);
                System.out.println(patient.toString());
                System.out.println("Total bill: "+patient.bills(visits, costPerVisit)+" tenge");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        //handle errors
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}