package com.example.banca4.repository;

import com.example.banca4.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor,Integer> {
    Optional<Donor> findByUserId(Integer id);
}
