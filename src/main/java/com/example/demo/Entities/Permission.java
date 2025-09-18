package com.example.demo.Entities;

public class Permission {
    // Patient
    private static final String PATIENT_VIEW_OWN_DATA = "PATIENT_VIEW_OWN_DATA";
    private static final String PATIENT_UPDATE_OWN_DATA = "PATIENT_UPDATE_OWN_DATA";
    private static final String PATIENT_VIEW_APPOINTMENTS = "PATIENT_VIEW_APPOINTMENTS";
    private static final String PATIENT_VIEW_OWN_RECORDS = "PATIENT_VIEW_OWN_RECORDS";
    private static final String PATIENT_VIEW_VITALS = "PATIENT_VIEW_VITALS";

    // Doctor
    private static final String DOCTOR_VIEW_ASSIGNED_PATIENTS = "DOCTOR_VIEW_ASSIGNED_PATIENTS";
    private static final String DOCTOR_ADD_MEDICAL_RECORDS = "DOCTOR_ADD_MEDICAL_RECORDS";
    private static final String DOCTOR_MANAGE_APPOINTMENTS = "DOCTOR_MANAGE_APPOINTMENTS";

    // Nurse
   private static final String NURSE_RECORD_PATIENTS_VITALS = "NURSE_RECORD_PATIENTS_VITALS";
   private static final String NURSE_VIEW_VITALS = "NURSE_VIEW_VITALS";

    // Admin
    private static final String ADMIN_MANAGE_USERS = "ADMIN_MANAGE_USERS";
    private static final String ADMIN_CREATE_DOCTORS_NURSES = "ADMIN_CREATE_DOCTORS_NURSES";
    private static final String ADMIN_MANAGE_APPOINTMENTS = "ADMIN_MANAGE_APPOINTEMTS";
}