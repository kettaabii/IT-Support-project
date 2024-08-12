package com.example.ITsupport.repository;

import com.example.ITsupport.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
    Technician findById(int id);

    List<Technician> findAllByAvailableIsTrue();
}
