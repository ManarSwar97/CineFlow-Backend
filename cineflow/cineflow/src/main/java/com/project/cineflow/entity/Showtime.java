package com.project.cineflow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="showtime_id")
    private int id;

    @Column(name="movie_id")
    private Movie movie;

    @Column(name="capacity")
    private int capacity;

    @Column(name="booked_count")
    private int bookedCount;

    @Column(name="price")
    private int price;

}
