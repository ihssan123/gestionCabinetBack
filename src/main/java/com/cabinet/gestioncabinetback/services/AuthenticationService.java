//package com.cabinet.gestioncabinetback.services;
//
//import com.cabinet.gestioncabinetback.AuthenticationRequest;
//import com.cabinet.gestioncabinetback.config.JwtService;
//import com.cabinet.gestioncabinetback.controllers.AuthenticationResponse;
//import com.cabinet.gestioncabinetback.controllers.RegisterRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//    private final DoctorRepository doctorRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//public AuthenticationResponse register(RegisterRequest request){
//    var user= Doctor.builder()
//            .nom(request.getNom())
//            .prenom(request.getPrenom())
//            .email(request.getEmail())
//            .password(passwordEncoder.encode(request.getPassword()))
//            .build();
//    doctorRepository.save(user);
//    var jwtToken=jwtService.generateToken(user);
//    return AuthenticationResponse.builder().token(jwtToken).build();
//}
//public  AuthenticationResponse authenticate(AuthenticationRequest request){
//    authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                    request.getEmail(),
//                    request.getPassword()
//            )
//    );
//    var user =doctorRepository.findByEmail(request.getEmail())
//            .orElseThrow();
//    var jwtToken=jwtService.generateToken(user);
//    return AuthenticationResponse.builder()
//            .token(jwtToken)
//            .build();
//}
//}
