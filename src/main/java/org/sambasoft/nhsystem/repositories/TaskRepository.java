package org.sambasoft.nhsystem.repositories;

import org.sambasoft.nhsystem.entities.Task;
import org.sambasoft.nhsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser(User user);
}
