package com.example.banca4.service;

import com.example.banca4.model.Donor;
import com.example.banca4.model.User;
import com.example.banca4.repository.DonorRepository;
import com.example.banca4.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * service ul contine logica fiecarui http request primit prin controller
 */
@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final DonorRepository donorRepository;



    public Boolean register(String email, String firstName, String lastName, String address, String bloodType, String password, String repeatPassword){
        if(password.compareTo(repeatPassword)!=0)
            return false;
        Optional<User> emailOptional=userRepository.findByEmail(email);
        if(emailOptional.isPresent())
            return false;
        User user = new User(0, email, password, 2);
        userRepository.save(user);
        user=userRepository.findByEmail(email).get();
        if(user == null)
            return false;

        Donor donor = new Donor(0, firstName, lastName, address, bloodType, user.getId());
        donorRepository.save(donor);

        return true;
    }

    public User login(String email, String password){
        Optional<User> loggedUser = userRepository.findByEmail(email);
        if(loggedUser.isPresent()) {
            User user = loggedUser.get();
            if(user.getPassword().compareTo(password)!=0)
                return null;
            return user;
        }
        return null;
    }

    public User getUserById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
            return null;
        User user = optionalUser.get();
        return user;
    }

    public Boolean editDonor(Integer userId, String firstName, String lastName, String address, String bloodType ) {
        Optional<Donor> optionalDonor = donorRepository.findByUserId(userId); //metodele findby din repository returneaza obiecte de tip optional
        //care exista sau nu, in caz pozitiv pot fi accesate dupa metoda get
        if(optionalDonor.isEmpty())
            return false;
        Donor donor = optionalDonor.get();
        donor.setFirstname(firstName);
        donor.setLastname(lastName);
        donor.setAddress(address);
        donor.setBloodType(bloodType);
        donorRepository.save(donor);// save in mod normal adauga un entry nou in tabela, dar daca ii dam un user deja existent doar il actualizeaza
        return true;

    }

    public Boolean deleteDonor(Integer userId){
        Optional<Donor> optionalDonor = donorRepository.findByUserId(userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalDonor.isEmpty())
            return false;
        if(optionalUser.isEmpty())
            return false;

        donorRepository.delete(optionalDonor.get());
        userRepository.delete(optionalUser.get());
        return true;


    }
}
