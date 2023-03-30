package com.example.banca4.controller;

import com.example.banca4.service.AppointmentService;
import com.example.banca4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

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
     * @param userId
     * @param data
     * @param time
     * @return true daca id urile sunt ok, false daca nu
     */
    @PostMapping("/appointment/add")
    public Boolean addAppointment(@RequestParam(defaultValue = "0") Integer doctorId, @RequestParam(defaultValue = "0") Integer userId,@RequestParam(defaultValue = "") Date data,@RequestParam(defaultValue = "") String time){
        if(doctorId == 0 || userId == 0|| time.length()==0)
            return false;
        return appointmentService.addAppointment(doctorId,userId,data,time);
    }
}
