package com.example.HealthcareBackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "surgeons")
public class Surgeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surgeonId;

    @Column(nullable = false)
    private String surgeonFirstName;

    @Column(nullable = false)
    private String surgeonLastName;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String clinicLocation;

    public Surgeon() {
    }

    public Surgeon(int surgeonId, String surgeonFirstName, String surgeonLastName, String specialization, String clinicLocation) {
        this.surgeonId = surgeonId;
        this.surgeonFirstName = surgeonFirstName;
        this.surgeonLastName = surgeonLastName;
        this.specialization = specialization;
        this.clinicLocation = clinicLocation;
    }

    public int getSurgeonId() {
        return surgeonId;
    }

    public void setSurgeonId(int surgeonId) {
        this.surgeonId = surgeonId;
    }

    public String getSurgeonFirstName() {
        return surgeonFirstName;
    }

    public void setSurgeonFirstName(String surgeonFirstName) {
        this.surgeonFirstName = surgeonFirstName;
    }

    public String getSurgeonLastName() {
        return surgeonLastName;
    }

    public void setSurgeonLastName(String surgeonLastName) {
        this.surgeonLastName = surgeonLastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getClinicLocation() {
        return clinicLocation;
    }

    public void setClinicLocation(String clinicLocation) {
        this.clinicLocation = clinicLocation;
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "surgeonId=" + surgeonId +
                ", surgeonFirstName='" + surgeonFirstName + '\'' +
                ", surgeonLastName='" + surgeonLastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", clinicLocation='" + clinicLocation + '\'' +
                '}';
    }
}
