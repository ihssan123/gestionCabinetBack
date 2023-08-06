package com.cabinet.gestioncabinetback.user;

import lombok.Getter;
import lombok.Setter;


public class Model {
    public boolean isAccepted;
    public Long idRdb;

    public boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Long getIdRdb() {
        return idRdb;
    }

    public void setIdRdb(Long idRdb) {
        this.idRdb = idRdb;
    }
}
