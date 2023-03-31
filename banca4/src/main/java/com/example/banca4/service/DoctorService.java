package com.example.banca4.service;

import com.example.banca4.model.Doctor;
import com.example.banca4.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService {
    @Autowired
    private final DoctorRepository doctorRepository;

    public List<Doctor> findAll(){
        return (List<Doctor>) doctorRepository.findAll();
    }

    public List<Doctor> findByLocationId(Integer locationId){
        return (List<Doctor>) doctorRepository.findAllByLocationId(locationId);
    }

    public Boolean add(String firstName, String lastName, Integer locationId, Integer program, Integer userId){
        if(program!=0 || program != 1) //daca program e 0 e pe dimineata, 1 e pe seara pentru interfata
            return false;
        Doctor doctor = new Doctor(0, firstName, lastName, locationId, program, userId);
        doctorRepository.save(doctor);
        return true;
    }

    public Boolean edit(Integer id, String firstName, String lastName, Integer locationId, Integer program, Integer userId){
        if(program!=0 && program != 1)
            return false;
        Optional<Doctor> optional = doctorRepository.findById(id);
        if(optional.isEmpty())
            return false;
        Doctor doctor = optional.get();
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setLocationId(locationId);
        doctor.setProgram(program);
        doctor.setUserId(userId);
        doctorRepository.save(doctor);
        return true;
    }

    public Boolean delete(Integer id){
        Optional<Doctor> optional = doctorRepository.findById(id);
        if(optional.isEmpty())
            return true;
        doctorRepository.delete(optional.get());
        return true;
    }
}
