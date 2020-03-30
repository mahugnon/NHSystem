package org.sambasoft.nhsystem.repositories;

import org.sambasoft.nhsystem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
