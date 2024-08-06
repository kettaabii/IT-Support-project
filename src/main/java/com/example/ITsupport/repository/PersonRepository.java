package com.example.ITsupport.repository;

import com.example.ITsupport.entity.Person;
import com.example.ITsupport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByUsername(String username);
}
