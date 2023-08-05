//package com.cabinet.gestioncabinetback.service;
//
//import com.cabinet.gestioncabinetback.repositories.RdvRepo;
//import com.cabinet.gestioncabinetback.user.RDV;
//import com.cabinet.gestioncabinetback.user.User;
//import com.cabinet.gestioncabinetback.user.UserRepository;
//
//public class RDVservice {
//    private final RdvRepo rdvRepository;
//    private final UserRepository userRepository; // Assuming you have a UserRepository to fetch doctors
//
//    public RDVservice(RdvRepo rdvRepository, UserRepository userRepository) {
//        this.rdvRepository = rdvRepository;
//        this.userRepository = userRepository;
//    }
//
//    //fonction for doctor who can put the plan of available appointment
//    public RDV planAppointment(RDV rdv, Long doctorId) {
//        rdv.setEtat(false); // The RDV is not confirmed initially
//
//        User doctor = userRepository.findById(doctorId)
//                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
//
//        rdv.setUser(doctor);
//        doctor.getRdv().add(rdv);
//
//        return rdvRepository.save(rdv);
//    }
//
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
//}