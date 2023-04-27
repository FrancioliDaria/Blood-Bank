package com.example.banca4.controller;

import com.example.banca4.model.Appointment;
import com.example.banca4.service.AppointmentService;
import com.example.banca4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * controller pentru opeatiile din tabela appointment
 */
@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    /**
     * userul poate adauga o noua programare, se ia id ul userului si se asociaza cu id doctor
     * @param doctorId
     * @param donorId
     * @param date
     * @param time
     * @return true daca id urile sunt ok, false daca nu
     */
    @CrossOrigin("http://localhost:3000")
    @PostMapping("/appointment/add")
    public Boolean addAppointment(@RequestParam(defaultValue = "0") Integer doctorId, @RequestParam(defaultValue = "0") Integer donorId,@RequestParam() String date, @RequestParam() String time){
        if(doctorId == 0 || donorId == 0|| time.length()==0)
            return false;
        return appointmentService.addAppointment(doctorId,donorId,Date.valueOf(date),time);
    }

    @GetMapping("/appointments")
    public Iterable<Appointment> appointments(@RequestParam(defaultValue = "0") Integer donorId, @RequestParam(defaultValue = "0") Integer doctorId){
        return appointmentService.appointments(donorId, doctorId);
    }

    @DeleteMapping("/appointment/delete")
    public Boolean delete(@RequestParam() Integer id){
        return appointmentService.delete(id);
    }
}
