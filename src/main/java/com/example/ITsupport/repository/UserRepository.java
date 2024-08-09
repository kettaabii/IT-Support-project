package com.example.ITsupport.repository;

import com.example.ITsupport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
