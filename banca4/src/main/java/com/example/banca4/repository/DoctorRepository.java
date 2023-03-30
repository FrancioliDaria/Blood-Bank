package com.example.banca4.repository;

import com.example.banca4.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * repository ne ajuta la query uri sql sa scriem mai rapid operatiile de tip crud
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    Iterable<Doctor> findAllByLocationId(Integer locationId);
}
