package org.example.repository;

import java.util.Optional;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
