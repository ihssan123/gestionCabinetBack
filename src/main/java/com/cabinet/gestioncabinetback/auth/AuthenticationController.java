package com.cabinet.gestioncabinetback.auth;
import com.cabinet.gestioncabinetback.auth.AuthenticationRequest;
import com.cabinet.gestioncabinetback.auth.AuthenticationResponse;
import com.cabinet.gestioncabinetback.auth.AuthenticationService;
import com.cabinet.gestioncabinetback.auth.RegisterRequest;
import com.cabinet.gestioncabinetback.helpers.jwtHelper;
import com.cabinet.gestioncabinetback.user.User;
import com.cabinet.gestioncabinetback.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")

//@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @Autowired
    public  final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
//    @PostMapping("/authenticate")
//    public ResponseEntity authenticate(
//            @RequestBody AuthenticationRequest request
//    ) {
//        try {
//            service.authenticate(request);
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        return ResponseEntity.ok("good");
//    }
@PostMapping("/authenticate")
public ResponseEntity authenticate(
        @RequestBody AuthenticationRequest request
) {
        try {
            var auth = service.authenticate(request);
            return ResponseEntity.ok(auth);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

}

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @GetMapping("/Profile")
    public ResponseEntity<User> docProfile(HttpServletRequest request) {
        var email = jwtHelper.getEmail(request);
        return ResponseEntity.ok(userRepository.findByEmail(email).get());

    }


}
