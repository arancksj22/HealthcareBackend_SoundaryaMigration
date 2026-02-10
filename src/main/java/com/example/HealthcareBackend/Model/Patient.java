package com.example.HealthcareBackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Column(nullable = false)
    private String patientFirstName;

    @Column(nullable = false)
    private String patientLastName;

    @Column(nullable = false)
    private int patientAge;

    @Column(nullable = false)
    private char patientGender;

    @Column(nullable = false)
    private String patientBloodGroup;

    @Column(nullable = false)
    private String patientDateAdmitted;

    public Patient() {
    }

    public Patient(int patientId, String patientFirstName, int patientAge, String patientLastName, char patientGender, String patientBloodGroup, String patientDateAdmitted) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientAge = patientAge;
        this.patientLastName = patientLastName;
        this.patientGender = patientGender;
        this.patientBloodGroup = patientBloodGroup;
        this.patientDateAdmitted = patientDateAdmitted;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public char getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(char patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientDateAdmitted() {
        return patientDateAdmitted;
    }

    public void setPatientDateAdmitted(String patientDateAdmitted) {
        this.patientDateAdmitted = patientDateAdmitted;
    }

    public String getPatientBloodGroup() {
        return patientBloodGroup;
    }

    public void setPatientBloodGroup(String patientBloodGroup) {
        this.patientBloodGroup = patientBloodGroup;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender=" + patientGender +
                ", patientBloodGroup='" + patientBloodGroup + '\'' +
                ", patientDateAdmitted='" + patientDateAdmitted + '\'' +
                '}';
    }
}
