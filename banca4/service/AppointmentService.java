package com.example.banca4.service;

import com.example.banca4.model.Appointment;
import com.example.banca4.model.Donor;
import com.example.banca4.model.Location;
import com.example.banca4.model.User;
import com.example.banca4.repository.AppointmentRepository;
import com.example.banca4.repository.DoctorRepository;
import com.example.banca4.repository.LocationRepository;
import com.example.banca4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService {

  @Autowired
  private final AppointmentRepository appointmentRepository;
  private final LocationRepository locationRepository;
  private final DoctorRepository doctorRepository;

  public Boolean addAppointment(Integer doctorId, Integer donorId, Date date, String time) {

    Appointment appointment = new Appointment(0, donorId, doctorId, date, time);
    appointmentRepository.save(appointment);

    return true;
  }

  public Iterable<Appointment> appointments(Integer donorId, Integer doctorId) {
    Iterable<Appointment> appointments;
    if (donorId == 0) {
      if (doctorId == 0)
        appointments = appointmentRepository.findAll();
      else
        appointments = appointmentRepository.findAllByDoctorId(doctorId);
    } else
      appointments = appointmentRepository.findAllByDonorId(donorId);

    for (Appointment appointment : appointments){
      appointment.setAddress(locationRepository.findById(doctorRepository.findById(appointment.getDoctorId()).get().getLocationId()).get().getAddress());
      appointment.setDoctorFirstName(doctorRepository.findById(doctorId).get().getFirstName());
      appointment.setDoctorLastName(doctorRepository.findById(doctorId).get().getLastName());
    }

    return appointments;
  }

  public Boolean delete(Integer id) {
    Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
    if (optionalAppointment.isEmpty())
      return false;
    Appointment appointment = optionalAppointment.get();
    Date nowDate = new Date(System.currentTimeMillis());
    int hour = Integer.parseInt(appointment.getTime().substring(0, appointment.getTime().indexOf(":")));
    int minute = Integer.parseInt(appointment.getTime().substring(appointment.getTime().indexOf(":") + 1));
    Long millis = appointment.getDate().getTime();
    millis += (60 * hour + minute) * 60 * 1000;
    if (System.currentTimeMillis() > millis)
      return false;
    appointmentRepository.delete(appointment);
    return true;
  }
}
