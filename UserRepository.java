package com.pavs.taskmanager.repository;

import com.pavs.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods will go here later
    User findByEmail(String email);
}
