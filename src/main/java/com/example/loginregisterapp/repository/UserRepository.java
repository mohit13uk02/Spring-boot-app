package com.example.loginregisterapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loginregisterapp.model.User;
public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByEmail(String email);
  boolean existsByUsername(String Username);
User findByEmailAndPassword(String email, String password);
}
