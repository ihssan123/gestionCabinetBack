package com.cabinet.gestioncabinetback.service;

import com.cabinet.gestioncabinetback.repositories.RdvRepo;
import com.cabinet.gestioncabinetback.user.RDV;
import com.cabinet.gestioncabinetback.user.Status;
import com.cabinet.gestioncabinetback.user.User;
import com.cabinet.gestioncabinetback.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RDVservice {
    private final RdvRepo rdvRepository;
    private final UserRepository userRepository; // Assuming you have a UserRepository to fetch doctors

    public RDVservice(RdvRepo rdvRepository, UserRepository userRepository) {
        this.rdvRepository = rdvRepository;
        this.userRepository = userRepository;
    }

    //fonction for doctor who can put the plan of available appointment
    public RDV planAppointment(RDV rdv, String email) {
             rdv.setStatus(Status.IN_PROGRESS); // The RDV is not confirmed initially
        User doctor = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        rdv.setDoctor(doctor);
       // doctor.getRDVDoc().add(rdv);

        return rdvRepository.save(rdv);
    }
    public List<RDV>  RDVOfDoctor(String email){
        User doctor = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        return doctor.getRDVDoc();

    }
    public RDV SaveRDV(RDV rdv){
       return rdvRepository.save(rdv);
    }

    public RDV createAppointmentRequest(String email, Long idRdv) {
        User patient = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
       RDV rdv= rdvRepository.findById(idRdv).get();
        rdv.setStatus(Status.IN_PROGRESS);// The RDV is not confirmed initially
        rdv.setPatient(patient);

        return rdvRepository.save(rdv);
    }
    public RDV acceptAppointment(Long rdvId) {
        RDV rdv = rdvRepository.findById(rdvId)
                .orElseThrow(() -> new IllegalArgumentException("RDV not found"));

        // Set the status to approved
        rdv.setStatus(Status.APPROVED);

        // Save the updated RDV in the repository
        return rdvRepository.save(rdv);
    }
    public RDV RefuseAppointment(Long rdvId) {
        RDV rdv = rdvRepository.findById(rdvId)
                .orElseThrow(() -> new IllegalArgumentException("RDV not found"));

        // Set the status to approved
        rdv.setStatus(Status.DENIED);

        // Save the updated RDV in the repository
        return rdvRepository.save(rdv);
    }




//    public RDV requestAppointment(RDV appointmentRequest, Long patientId) {
//        appointmentRequest.setEtat(false); // The appointment is not confirmed initially
//
//        User patient = userRepository.findById(patientId)
//                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
//
//        appointmentRequest.setUser(patient);
//        patient.getRdv().add(appointmentRequest);
//
//        return rdvRepository.save(appointmentRequest);
//
//    }
}