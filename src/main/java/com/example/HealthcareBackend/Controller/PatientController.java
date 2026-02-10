package com.example.HealthcareBackend.Controller;

import com.example.HealthcareBackend.Model.Patient;
import com.example.HealthcareBackend.Service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    PatientService service;

    public PatientController(PatientService service){
        this.service = service;
    }

    @GetMapping
    public String patientControllerGreeting(){
        return "Hello! This is the Patient Controller Endpoint!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable int id){
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> addPatient(@RequestParam Patient patient){
        service.addOne(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updatePatient(@RequestParam Patient patient){
        service.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOne(@PathVariable int id){
        service.deleteOne(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/deleter/final")
    public ResponseEntity<Void> deleteAll(){
        service.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
