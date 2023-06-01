package com.example.banca4.controller;

import com.example.banca4.model.Appointment;
import com.example.banca4.model.Badge;
import com.example.banca4.model.User;
import com.example.banca4.service.AppointmentService;
import com.example.banca4.service.UserService;
import com.example.banca4.controller.UserController;
import com.example.banca4.EmailFactory.EmailService;
import com.example.banca4.service.UserService;
//import com.example.banca4.EmailFactory.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * controller pentru opeatiile din tabela appointment
 */
@RestController
public class AppointmentController {

  @Autowired
  private UserService userService;
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

      User donor = userService.getUserById(donorId);
      if (donor != null) {
        String donorEmail = donor.getEmail();
        String subject = "New Appointment";
        String body = "A new appointment has been scheduled for you. Details: Date: " + date + ", Time: " + time;
        emailService.sendEmail(donorEmail, subject, body); // Utilizați EmailService pentru a trimite e-mailul
      } else {
        // Tratarea cazului în care nu se găsește utilizatorul donator
        return false;
      }


        return appointmentService.addAppointment(doctorId,donorId,Date.valueOf(date),time);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/appointments")
    public Iterable<Appointment> appointments(@RequestParam(defaultValue = "0") Integer donorId, @RequestParam(defaultValue = "0") Integer doctorId, @RequestParam(defaultValue = "2001-4-19") Date date) {
      // Am pus o data default in cazul in care nu este trimisa la request (ziua mea de nastere)
      //Daca nu e trimisa data, returnam toate appointmenturile, altfel doar cele dind ata respectiva
      //aici verificam daca data este cea implicita
      String dateString = "2001-4-19";
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
      java.util.Date parsedDate;
      Date sqlDate = null;

      try {
        parsedDate = dateFormat.parse(dateString);
        sqlDate = new java.sql.Date(parsedDate.getTime());
      } catch (ParseException e) {
        e.printStackTrace();
      }

      if(sqlDate!=null && sqlDate.compareTo(date) == 0)
        date = null;

      return appointmentService.appointments(donorId, doctorId, date);
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/appointment/delete")
    public Boolean delete(@RequestParam() Integer id){
        return appointmentService.delete(id);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/appointment/hours")
    public List<String> getAvailableHours(@RequestParam(defaultValue = "0") Integer doctorId, @RequestParam(defaultValue = "2001-4-19") Date date){
      return appointmentService.getAvailableHours(doctorId, date);
    }

}
