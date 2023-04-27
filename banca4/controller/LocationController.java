package com.example.banca4.controller;

import com.example.banca4.model.Location;
import com.example.banca4.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pt operatiile pe tabela locatii
 */
@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    /**
     * gasim fiecare locatie dupa un id al ei
     * @param id
     * @return locatia daca s-a gasit id, null daca nu
     */
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/location")
    public Location findById(@RequestParam(defaultValue = "0") Integer id){
        if(id == 0)
            return null;
        return locationService.findById(id);
    }

    /**
     *
     * @return toata lista
     */
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/locations")
    public List<Location> findAll(){
        return locationService.findAll();
    }
}
