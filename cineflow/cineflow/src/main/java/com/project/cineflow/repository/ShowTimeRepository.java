package com.project.cineflow.repository;

import com.project.cineflow.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<Showtime, Integer> {
}
