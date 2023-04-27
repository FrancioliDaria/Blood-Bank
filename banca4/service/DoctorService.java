package com.example.banca4.service;

import com.example.banca4.model.Doctor;
import com.example.banca4.model.User;
import com.example.banca4.repository.DoctorRepository;
import com.example.banca4.repository.UserRepository;
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
    private final UserRepository userRepository;

    public List<Doctor> findAll(){
        return (List<Doctor>) doctorRepository.findAll();
    }

    public List<Doctor> findByLocationId(Integer locationId){
        return (List<Doctor>) doctorRepository.findAllByLocationId(locationId);
    }

    public Boolean add(String email, String password, String firstName, String lastName, Integer locationId){
        User user = new User(0, email, password, 1);
        Optional<User> emailOptional=userRepository.findByEmail(email);
        if(emailOptional.isPresent())
            return false;
        userRepository.save(user);
        int userId = userRepository.findByEmail(email).get().getId();
        Doctor doctor = new Doctor(0, firstName, lastName, locationId, userId);
        doctorRepository.save(doctor);
        return true;
    }

    public Boolean edit(Integer id, String email, String password, String firstName, String lastName, Integer locationId){
        Optional<Doctor> optional = doctorRepository.findById(id);
        if(optional.isEmpty())
            return false;
        Optional<User> optionalUser = userRepository.findById(optional.get().getUserId());
        if(optionalUser.isEmpty())
            return false;
        User user = optionalUser.get();
        if(email.length()>0)
            user.setEmail(email);
        if(password.length()>0)
            user.setPassword(password);
        Doctor doctor = optional.get();
        if(firstName.length()>0)
            doctor.setFirstName(firstName);
        if(lastName.length()>0)
            doctor.setLastName(lastName);
        if(locationId!=0)
            doctor.setLocationId(locationId);
        doctorRepository.save(doctor);
        return true;
    }

    public Boolean delete(Integer id){
        Optional<Doctor> optional = doctorRepository.findById(id);
        if(optional.isEmpty())
            return false;
        userRepository.delete(userRepository.findById(optional.get().getUserId()).get());
        doctorRepository.delete(optional.get());
        return true;
    }
}
