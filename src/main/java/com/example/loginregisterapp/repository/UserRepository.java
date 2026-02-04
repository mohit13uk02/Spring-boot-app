package com.example.loginregisterapp.repository;
import com.example.loginregisterapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByEmail(String email);
User findByEmailAndPassword(String email, String password);
}
