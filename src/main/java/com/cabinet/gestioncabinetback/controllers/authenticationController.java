//package com.cabinet.gestioncabinetback.controllers;
//
//import com.cabinet.gestioncabinetback.AuthenticationRequest;
//import com.cabinet.gestioncabinetback.services.AuthenticationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////@RestController
//@RequestMapping("/doc/auth")
//@RequiredArgsConstructor
//public class authenticationController {
//    private  final AuthenticationService service;
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ){
//         return  ResponseEntity.ok(service.register(request));
//
//    }
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody AuthenticationRequest request
//    ){
//        return  ResponseEntity.ok(service.authenticate(request));
//
//    }
//}
