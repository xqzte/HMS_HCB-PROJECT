package com.example.demo.ServiceInterface;

import com.example.demo.Entities.AppointmentStatus;
import com.example.demo.Entities.Appointments;
import com.example.demo.Entities.MedicalRecord;

import java.util.List;

public interface AppointmentServiceInterface {

        List<Appointments> getAppointmentsByDoctorId(Long doctorId);
        List<Appointments> getAppointmentsByStatus(AppointmentStatus status);
        Appointments getAppointmentById(Long appointmentId);
//        MedicalRecord getMedicalRecordFromAppointment(Long appointmentId);
//        List<Appointments> getAppointmentsForNurseView();
        Appointments createAppointment(Appointments appointment);

        Appointments updateAppointmentStatus(Long appointmentId, AppointmentStatus status);

        void deleteAppointment(Long appointmentId);

        List<Appointments> getAppointmentsByPatientId(Long patientId);

}

