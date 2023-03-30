package com.example.banca4.service;

import com.example.banca4.model.Appointment;
import com.example.banca4.model.Donor;
import com.example.banca4.model.User;
import com.example.banca4.repository.AppointmentRepository;
import com.example.banca4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

    public Boolean addAppointment(Integer doctorId, Integer userId, Date data, String time){

       Appointment appointment = new Appointment(0,userId,doctorId,data,time);
       appointmentRepository.save(appointment);

        return true;
    }
}
