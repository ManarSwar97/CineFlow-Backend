package com.project.cineflow.repository;

import com.project.cineflow.entity.User;
import com.project.cineflow.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Optional<user> --> might be a user or might not
    //select * from User where username := username;
    //auto create the query
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String Email);

    User findByRole(UserRole role);

}
