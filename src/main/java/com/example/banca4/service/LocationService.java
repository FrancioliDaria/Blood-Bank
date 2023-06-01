package com.example.banca4.service;

import com.example.banca4.model.Location;
import com.example.banca4.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {
    @Autowired
    private final LocationRepository locationRepository;

    public Location findById(Integer id){
        if(locationRepository.findById(id).isEmpty())
            return null;
        return locationRepository.findById(id).get();
    }

    public List<Location> findAll(){
        return (List<Location>) locationRepository.findAll();
    }
}
