package com.example.demo.Entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;


public enum Role {

    PATIENT,
    DOCTOR,
    NURSE,
    ADMIN;

    private Set<Permissions> permissions;

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    static {
        PATIENT.permissions = Set.of(
                Permissions.PATIENT_VIEW_OWN_DATA,
                Permissions.PATIENT_UPDATE_OWN_DATA,
                Permissions.PATIENT_VIEW_APPOINTMENTS,
                Permissions.PATIENT_VIEW_OWN_RECORDS,
                Permissions.PATIENT_VIEW_VITALS
        );

        DOCTOR.permissions = Set.of(
                Permissions.DOCTOR_VIEW_ASSIGNED_PATIENTS,
                Permissions.DOCTOR_ADD_MEDICAL_RECORDS,
                Permissions.DOCTOR_MANAGE_APPOINTMENTS
        );

        NURSE.permissions = Set.of(
                Permissions.NURSE_RECORD_PATIENTS,
                Permissions.NURSE_VIEW_VITALS
        );

        ADMIN.permissions = Set.of(
                Permissions.ADMIN_MANAGE_USERS,
                Permissions.ADMIN_CREATE_DOCTORS_NURSES,
                Permissions.ADMIN_MANAGE_APPOINTMENTS
        );
    }
}