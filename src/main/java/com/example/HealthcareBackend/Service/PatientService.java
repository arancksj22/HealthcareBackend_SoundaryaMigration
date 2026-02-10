package com.example.HealthcareBackend.Service;

import com.example.HealthcareBackend.Model.Patient;
import com.example.HealthcareBackend.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientRepository repo;

    public PatientService(PatientRepository repo){
        this.repo = repo;
    }

    public Patient getOne(int id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public List<Patient> getAll(){
        return repo.findAll();
    }

    public void addOne(Patient patient){
        repo.save(patient);
    }

    public void updatePatient(Patient patient) {
        if (patient.getPatientId() <= 0) {
            throw new RuntimeException("Patient ID must be provided for update.");
        }

        Patient existingPatient = repo.findById(patient.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient with ID " + patient.getPatientId() + " not found."));

        existingPatient.setPatientFirstName(patient.getPatientFirstName());
        existingPatient.setPatientLastName(patient.getPatientLastName());
        existingPatient.setPatientAge(patient.getPatientAge());
        existingPatient.setPatientGender(patient.getPatientGender());
        existingPatient.setPatientBloodGroup(patient.getPatientBloodGroup());
        existingPatient.setPatientDateAdmitted(patient.getPatientDateAdmitted());

        repo.save(existingPatient);
    }

    public void deleteOne(int id){
        repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }
}
