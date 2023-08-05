package com.cabinet.gestioncabinetback.auth;
import com.cabinet.gestioncabinetback.auth.AuthenticationRequest;
import com.cabinet.gestioncabinetback.auth.AuthenticationResponse;
import com.cabinet.gestioncabinetback.auth.AuthenticationService;
import com.cabinet.gestioncabinetback.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

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


}
