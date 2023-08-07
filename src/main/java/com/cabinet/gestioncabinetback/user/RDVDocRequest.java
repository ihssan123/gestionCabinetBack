package com.cabinet.gestioncabinetback.user;

import java.time.LocalDateTime;

public class RDVDocRequest {
    private LocalDateTime dateRDV;

    public RDVDocRequest(LocalDateTime dateRDV) {
        this.dateRDV = dateRDV;
    }
    public RDVDocRequest() {

    }
    public LocalDateTime getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(LocalDateTime dateRDV) {
        this.dateRDV = dateRDV;
    }
}
