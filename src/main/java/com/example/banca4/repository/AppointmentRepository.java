package com.example.banca4.repository;

import com.example.banca4.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Iterable<Appointment> findAllByDonorId(Integer donorId);
    Iterable<Appointment> findAllByDonorIdAndDate(Integer donorId, Date date);
    Iterable<Appointment> findAllByDoctorId(Integer doctorId);
    Iterable<Appointment> findAllByDate(Date date);
    Iterable<Appointment> findAllByDoctorIdAndDate(Integer doctorId, Date date);
   long countByDonorId(Integer donorId);

}
