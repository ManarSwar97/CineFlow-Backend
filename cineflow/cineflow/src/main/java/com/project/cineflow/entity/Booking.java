package com.project.cineflow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private int id;

    @Column(name="user_id")
    private User user;

    @Column(name="showtime_id")
    private Showtime showtime;

    @Column(name="ticket_count")
    private int ticketCount;

    @Column(name="status")
    private String Status;

    @Column(name="created_at")
    private LocalDateTime createdAt;

}
