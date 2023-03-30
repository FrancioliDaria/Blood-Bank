package com.example.banca4.controller;

import com.example.banca4.model.Doctor;
import com.example.banca4.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controler pentru operatiile din tabela doctor
 */
@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    /**
     *
     * @return toata lista de doctori
     */
    @GetMapping("/doctors")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    /**
     *
     * @param locationId
     * @return returneaza fiecare doctor dupa idul locatiei in care lucreaza
     */
    @GetMapping("/doctor")
    public List<Doctor> findByLocationId(@RequestParam(defaultValue = "0") Integer locationId){
        if(locationId == 0)
            return null;
        return doctorService.findByLocationId(locationId);
    }

    /**
     * Adminul poate adauga doctori+parametrii lor
     * @param firstName
     * @param lastName
     * @param locationId
     * @param program
     * @param userId
     * @return true daca eu fost introdusi parametrii ok, false daca nu
     */
    @PostMapping("/doctor/add")
    public Boolean add(@RequestParam(defaultValue = "") String firstName, @RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "0") Integer locationId, @RequestParam(defaultValue = "0") Integer program, @RequestParam(defaultValue = "0") Integer userId){
        if(firstName.length() == 0 || lastName.length() == 0)
            return false;
        return doctorService.add(firstName, lastName, locationId, program, userId);
    }

    /**
     * Editeaza parametrii doctorului
     * @param id
     * @param firstName
     * @param lastName
     * @param locationId
     * @param program
     * @param userId
     * @return
     */
    @PutMapping("/doctor/edit")
    public Boolean edit(@RequestParam(defaultValue = "0") Integer id, @RequestParam(defaultValue = "") String firstName, @RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "0") Integer locationId, @RequestParam(defaultValue = "0") Integer program, @RequestParam(defaultValue = "0") Integer userId){
        if(firstName.length() == 0 || lastName.length() == 0)
            return false;
        return doctorService.edit(id, firstName, lastName, locationId, program, userId);
    }

    @DeleteMapping("/doctor/delete")
    public Boolean delete(@RequestParam(defaultValue = "0") Integer id){
        return doctorService.delete(id);
    }
}
