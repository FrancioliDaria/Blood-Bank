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

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/doctors")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    /**
     *
     * @param locationId
     * @return returneaza fiecare doctor dupa idul locatiei in care lucreaza
     */

    @CrossOrigin("http://localhost:3000") //callurile catre backend
    @GetMapping("/doctor")
    public List<Doctor> findByLocationId(@RequestParam(defaultValue = "0") Integer locationId){
        if(locationId == 0)
            return null;
        return doctorService.findByLocationId(locationId);
    }

    /**
     * Adminul poate adauga doctori+parametrii lor
     * @return true daca eu fost introdusi parametrii ok, false daca nu
     */
    @CrossOrigin("http://localhost:3000")
    @PostMapping("/doctor/add")
    public Boolean add(@RequestParam() String email, @RequestParam() String password, @RequestParam() String firstName, @RequestParam() String lastName, @RequestParam(defaultValue = "0") Integer locationId){
        if(firstName.length() == 0 || lastName.length() == 0)
            return false;
        return doctorService.add(email, password, firstName, lastName, locationId);
    }

    /**
     * Editeaza parametrii doctorului
     * @return
     */
    @CrossOrigin("http://localhost:3000")
    @PutMapping("/doctor/edit")
    public Boolean edit(@RequestParam(defaultValue = "0") Integer id, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String firstName, @RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "0") Integer locationId){
        return doctorService.edit(id, email, password, firstName, lastName, locationId);
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/doctor/delete")
    public Boolean delete(@RequestParam(defaultValue = "0") Integer id){
        return doctorService.delete(id);
    }
}
