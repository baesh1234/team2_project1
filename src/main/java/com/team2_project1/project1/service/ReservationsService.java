package com.team2_project1.project1.service;

import com.team2_project1.project1.domain.Reservations;
import com.team2_project1.project1.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {
    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsService(ReservationsRepository reservationsRepository) { this.reservationsRepository = reservationsRepository;}

    //전체 예약 조회
    public List<Reservations> findReservations() {
        return reservationsRepository.findAll();
    }

}
