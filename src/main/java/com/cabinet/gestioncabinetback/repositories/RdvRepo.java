package com.cabinet.gestioncabinetback.repositories;

import com.cabinet.gestioncabinetback.user.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepo extends JpaRepository<RDV,Long> {


}
