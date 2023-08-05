package com.cabinet.gestioncabinetback.user;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    DOCTOR_READ("doctor:read"),
    DOCTOR_UPDATE("doctor:update"),
    DOCTOR_CREATE("doctor:create"),
    DOCTOR_DELETE("doctor:delete"),
    PATIENT_READ("doctor:read"),
    PATIENT_UPDATE("doctor:update"),
    PATIENT_CREATE("doctor:create"),
    PATIENT_DELETE("doctor:delete")

    ;

    @Getter
    private final String permission;
}
