package com.example.banca4.controller;

import com.example.banca4.model.User;
import com.example.banca4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling http request related to the user table
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Salveaza in baza de date un user nou in cazul in care nu exista deja mailul, si daca sunt identice password si repeat password.
     * Verificam daca am primit toti parametrii, chiar daca au default value
     * @param email
     * @param firstName
     * @param lastName
     * @param address
     * @param bloodType
     * @param password
     * @param repeatPassword
     * @return true daca indeplineste cerinta, false daca nu
     */
    @PostMapping("/user/register")
    public Boolean register(@RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String firstName, @RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "") String address, @RequestParam(defaultValue = "") String bloodType,@RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String repeatPassword){
        if(email.length()==0||password.length()==0||repeatPassword.length()==0||firstName.length()==0||lastName.length()==0||address.length()==0)
            return false;
        return userService.register(email, firstName, lastName, address, bloodType,password, repeatPassword);
    }

    /**
     * Cauta emailul in baza de date si compara parola cucea din baza de date
     * @param email
     * @param password
     * @return userul daca e gasit , null daca nu
     */
    @GetMapping("/user/login")
    public User login(@RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String password){
        if(email.length() == 0 || password.length() == 0)
            return null;
        return userService.login(email,password);

    }

    /**
     * Fiecare user are un id si il identificam dupa id
     * @param id
     * @return userul daca exista id, null daca nu
     */
    @GetMapping("/user/getById")
    public User getUserById(@RequestParam(defaultValue = "0") Integer id){
        if(id == 0)
            return null;
        return userService.getUserById(id);
    }

    /**
     * Schimba parametrii userului gasit cu id, cu toti parametrii primiti
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param bloodType
     * @return true daca e schimbat cu succes
     */
    @PutMapping("/user/edit")
    public Boolean editDonor(@RequestParam(defaultValue = "0") Integer id, @RequestParam(defaultValue = "") String firstName, @RequestParam(defaultValue = "") String lastName, @RequestParam(defaultValue = "") String address, @RequestParam(defaultValue = "") String bloodType){
        if(id == 0)
            return false;
        return userService.editDonor(id,firstName,lastName,address,bloodType);
    }


    @DeleteMapping("/user/delete")
    public Boolean deleteDonor(@RequestParam(defaultValue = "0") Integer id){
        if(id == 0 )
            return false;
        return userService.deleteDonor(id);
    }

}
