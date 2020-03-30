package org.sambasoft.nhsystem.repositories;

import org.sambasoft.nhsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "Select u from  User u where u.email= :email")
    User findOne(@Param("email") String email);

    List<User> findByNameLike(String name);
}
