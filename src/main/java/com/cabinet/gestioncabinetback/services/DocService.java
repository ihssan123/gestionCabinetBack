//package com.cabinet.gestioncabinetback.services;
//
//import com.cabinet.gestioncabinetback.entities.RDV;
//import com.cabinet.gestioncabinetback.repositories.RdvRepo;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DocService {
//    private final RdvRepo rdvRepository;
//    private final DoctorRepository doctorRepository;
//
//    public DocService(RdvRepo rdvRepository, DoctorRepository doctorRepository) {
//        this.rdvRepository = rdvRepository;
//        this.doctorRepository = doctorRepository;
//    }
//
//    public RDV planifierRDV(RDV rdv, Long doctorId) {
//        rdv.setEtat(false); // The RDV is not confirmed initially
//
//        Doctor doctor = doctorRepository.findById(doctorId)
//                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
//
//        rdv.setDoctor(doctor);
//        doctor.getRdv().add(rdv);
//
//        return rdvRepository.save(rdv);
//    }
//}
