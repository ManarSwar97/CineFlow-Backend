package com.project.cineflow.repository;

import com.project.cineflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //Optional<user> --> might be a user or might not
    //select * from User where username := username;
    //auto create the query
    Optional<User> findByUsername(String username);
}
