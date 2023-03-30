package com.example.banca4.repository;

import com.example.banca4.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public Optional<User> findByEmail(String email);
}
