package com.cabinet.gestioncabinetback.repositories;

import com.cabinet.gestioncabinetback.user.RDV;
import com.cabinet.gestioncabinetback.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepo extends JpaRepository<RDV,Long> {

    List<RDV> findByDoctorIdUser(Long doctorIdUser);

}
