package com.example.banca4.repository;

import com.example.banca4.model.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends CrudRepository<Donor,Integer> {

    public Optional<Donor> findByUserId(Integer id);

}
