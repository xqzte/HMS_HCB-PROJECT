package com.example.demo.Service;

import com.example.demo.Entities.AppointmentStatus;
import com.example.demo.Entities.Appointments;
import com.example.demo.Repository.AppointmentRepository;
import com.example.demo.ServiceInterface.AppointmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService implements AppointmentServiceInterface {
    @Autowired
    private AppointmentRepository appointmentRepository;

        @Override
        public List<Appointments> getAppointmentsByDoctorId(Long doctorId) {
            return appointmentRepository.findByDoctorId(doctorId);
        }

        @Override
        public List<Appointments> getAppointmentsByStatus(AppointmentStatus status) {
            return appointmentRepository.findByStatus(status);
        }

        @Override
        public Appointments getAppointmentById(Long appointmentId) {
            return appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new RuntimeException("Appointment not found"));
        }

//        @Override
//        public MedicalRecord getMedicalRecordFromAppointment(Long appointmentId) {
//            Appointments appointment = getAppointmentById(appointmentId);
//            return appointment.getMedicalRecord();
//        }
//
//        @Override
//        public List<Appointments> getAppointmentsForNurseView() {
//            return appointmentRepository.findAll();
//        }

    @Override
    public Appointments createAppointment(Appointments appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointments updateAppointmentStatus(Long appointmentId, AppointmentStatus status) {
        Appointments appointment = getAppointmentById(appointmentId);
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<Appointments> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

}

