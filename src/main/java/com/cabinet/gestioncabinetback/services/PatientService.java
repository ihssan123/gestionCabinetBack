//package com.cabinet.gestioncabinetback.services;
//
//import com.cabinet.gestioncabinetback.entities.RDV;
//import com.cabinet.gestioncabinetback.repositories.RdvRepo;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PatientService {
//    private final RdvRepo rdvRepository;
//    private final PatientRepo patientRepository;
//
//    public PatientService(RdvRepo rdvRepository, PatientRepo patientRepository) {
//        this.rdvRepository = rdvRepository;
//        this.patientRepository = patientRepository;
//    }
//
//    public RDV demandeRDV(RDV rdv, Long patientId) {
//        rdv.setEtat(false); // Le RDV n'est pas confirmé initialement
//
//        Patient patient = patientRepository.findById(patientId)
//                .orElseThrow(() -> new IllegalArgumentException("Patient non trouvé"));
//
//        rdv.setPatient(patient);
//        patient.getRdv().add(rdv);
//
//        return rdvRepository.save(rdv);}
//}
