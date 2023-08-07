package com.cabinet.gestioncabinetback.controller;
import com.cabinet.gestioncabinetback.helpers.jwtHelper;
import com.cabinet.gestioncabinetback.repositories.RdvRepo;
import com.cabinet.gestioncabinetback.service.RDVservice;
import com.cabinet.gestioncabinetback.user.RDV;
import com.cabinet.gestioncabinetback.user.Role;
import com.cabinet.gestioncabinetback.user.*;
import com.cabinet.gestioncabinetback.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/doc")
@RequiredArgsConstructor
public class DocController {

    @Autowired
    public final UserRepository userRepository;
    @Autowired
    public final RDVservice rdVservice;
    @Autowired
    public  final  RdvRepo rdvRepo;


    @GetMapping("/Profile")
    public ResponseEntity<User> docProfile(HttpServletRequest request) {
        var email = jwtHelper.getEmail(request);
        return ResponseEntity.ok(userRepository.findByEmail(email).get());

    }

    @GetMapping("/role")
    public ResponseEntity<Role> GetRole(HttpServletRequest request) {
        var email = jwtHelper.getEmail(request);
        return ResponseEntity.ok(userRepository.findByEmail(email).get().getRole());
    }
    @GetMapping("/doctors")
    public ResponseEntity<List<User>> getAllDoctors(HttpServletRequest request) {
        List<User> allUsers = userRepository.findAll();

        List<User> doctors = allUsers.stream()
                .filter(user -> user.getRole() == Role.DOCTOR)
                .collect(Collectors.toList());

        return ResponseEntity.ok(doctors);
    }
    @PostMapping("/rendezVous")
    public RDV planifierDocRDV(HttpServletRequest request,@RequestBody RDVDocRequest rdv) {
        var email = jwtHelper.getEmail(request);
        return rdVservice.planAppointment(rdv,email);


    }
    @GetMapping("/rdvs/{email}")
    public List<RDV> RdvDoctor(@PathVariable String email ) {
        User doctor=userRepository.findByEmail(email).get();
        return doctor.getRDVDoc();


    }
    @GetMapping("/rdvsPatient/{email}")
    public List<RDV> RdvPatient(@PathVariable String email ) {
        User patient=userRepository.findByEmail(email).get();
        return patient.getRDVPat();


    }
    @PostMapping("/patientRequest/{idRdv}")
    public RDV createAppointmentRequest(HttpServletRequest request, @PathVariable Long idRdv){
        var email = jwtHelper.getEmail(request);
        return  rdVservice.createAppointmentRequest(email,idRdv);


    }
    @PostMapping("/accept/{idRdv}")
    public RDV acceptAppointment(HttpServletRequest request,@PathVariable Long idRdv){

        return rdVservice.acceptAppointment(idRdv);
    }
    @PostMapping("/Rejet/{idRdv}")
    public RDV RefuseAppointment(@PathVariable Long idRdv){
        return rdVservice.RefuseAppointment(idRdv);
    }

    @GetMapping("/patientsDemande")
    public List<RDV> getPatientsDemande(HttpServletRequest request) {
        var email = jwtHelper.getEmail(request);
        var doctor = userRepository.findByEmail(email);
        List<RDV> allRDVs = rdvRepo.findByDoctorIdUser(doctor.get().getIdUser()); // Get all RDV objects
//        List<RDV> rdvsInProcessForDoctor = allRDVs.stream()
//                .filter(rdv -> rdv.getStatus() == Status.RESERVED && rdv.getDoctor().getEmail() == email)
//                .collect(Collectors.toList());

        return allRDVs;

    }





}