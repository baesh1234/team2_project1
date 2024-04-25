package com.team2_project1.project1.repository;

import com.team2_project1.project1.domain.Reservations;

import java.util.List;

public interface ReservationsRepository {
    List<Reservations> findAll();
}
