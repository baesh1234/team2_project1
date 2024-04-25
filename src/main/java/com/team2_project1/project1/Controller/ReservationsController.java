package com.team2_project1.project1.Controller;

import com.team2_project1.project1.domain.Reservations;
import com.team2_project1.project1.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ReservationsController {
    private final ReservationsService reservationsService;

    @Autowired
    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping("/reservations")
    public String List(Model model){
        List<Reservations> reservations = reservationsService.findReservations();
        model.addAttribute("reservations", reservations);
        return "reservations/List";}
}
