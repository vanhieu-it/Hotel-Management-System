package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Role;
import org.example.entity.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByRoleName(RoleName roleName);
}
