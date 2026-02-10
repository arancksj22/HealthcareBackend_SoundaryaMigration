package com.example.HealthcareBackend.Service;

import com.example.HealthcareBackend.Model.Patient;
import com.example.HealthcareBackend.Repository.PatientRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientRepository repo;

    public PatientService(PatientRepository repo){
        this.repo = repo;
    }

    @Cacheable(value = "patients", key = "#id")
    public Patient getOne(int id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Cacheable(value = "allPatients")
    public List<Patient> getAll(){
        return repo.findAll();
    }

    @CacheEvict(value = "allPatients", allEntries = true)
    public void addOne(Patient patient){
        repo.save(patient);
    }

    @Caching(evict = {
            @CacheEvict(value = "patients", key = "#patient.patientId"),
            @CacheEvict(value = "allPatients", allEntries = true)
    })
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

    @Caching(evict = {
            @CacheEvict(value = "patients", key = "#id"),
            @CacheEvict(value = "allPatients", allEntries = true)
    })
    public void deleteOne(int id){
        repo.deleteById(id);
    }

    @Caching(evict = {
            @CacheEvict(value = "patients", allEntries = true),
            @CacheEvict(value = "allPatients", allEntries = true)
    })
    public void deleteAll(){
        repo.deleteAll();
    }
}
