package com.example.demo.Entities;

import java.util.Set;

public enum Role {

    PATIENT(Set.of(
            Permissions.PATIENT_VIEW_OWN_DATA,
            Permissions.PATIENT_UPDATE_OWN_DATA,
            Permissions.PATIENT_VIEW_APPOINTMENTS,
            Permissions.PATIENT_VIEW_OWN_RECORDS,
            Permissions.PATIENT_VIEW_VITALS
    )),

    DOCTOR(Set.of(
            Permissions.DOCTOR_VIEW_ASSIGNED_PATIENTS,
            Permissions.DOCTOR_ADD_MEDICAL_RECORDS,
            Permissions.DOCTOR_MANAGE_APPOINTMENTS
    )),

    NURSE(Set.of(
            Permissions.NURSE_RECORD_PATIENTS,
            Permissions.NURSE_VIEW_VITALS
    )),

    ADMIN(Set.of(
            Permissions.ADMIN_MANAGE_USERS,
            Permissions.ADMIN_CREATE_DOCTORS_NURSES,
            Permissions.ADMIN_MANAGE_APPOINTMENTS
    ));

    private final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}