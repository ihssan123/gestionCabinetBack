package com.cabinet.gestioncabinetback.controller;

import com.cabinet.gestioncabinetback.repositories.RdvRepo;
import com.cabinet.gestioncabinetback.service.RDVservice;
import com.cabinet.gestioncabinetback.user.Model;
import com.cabinet.gestioncabinetback.user.RDV;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.cabinet.gestioncabinetback.helpers.jwtHelper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rdv")
public class RDVController {
        private final RDVservice _rdVservice;
        private  final RdvRepo rdvRepo;
    public Claims parseToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);

            Claims claims = Jwts.parser()
                    .setSigningKey("404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970")
                    .parseClaimsJws(jwtToken)
                    .getBody();

            // Extract claims from the parsed JWT
            String username = claims.getSubject();
            String email = claims.get("email", String.class);

            return claims;
        } else {
            return null;
        }
    }

    public RDVController(RDVservice rdVservice, RdvRepo rdvRepo) {
        this._rdVservice = rdVservice;

        this.rdvRepo = rdvRepo;
    }


    @PostMapping("/doc")
        public RDV planifierDocRDV(HttpServletRequest request,RDV rdv) {
        var email = jwtHelper.getEmail(request);
        return _rdVservice.planAppointment(rdv,email);


        }
    @GetMapping("/doc/getallRDV")
    public List<RDV> getallrdv(HttpServletRequest request) {
        var email = jwtHelper.getEmail(request);
        return _rdVservice.RDVOfDoctor(email);


    }
    @PostMapping("/patient/Request/{idRdv}")
    public RDV createAppointmentRequest(HttpServletRequest request, @PathVariable Long idRdv){
        var email = jwtHelper.getEmail(request);
      return  _rdVservice.createAppointmentRequest(email,idRdv);


    }
    @PostMapping("/doc/accept/{idRdv}")
    public RDV acceptAppointment(@PathVariable Long idRdv){
      return _rdVservice.acceptAppointment(idRdv);
    }
    @PostMapping("/doc/Rejet/{idRdv}")
    public RDV RefuseAppointment(@PathVariable Long idRdv){
        return _rdVservice.RefuseAppointment(idRdv);
    }




}
