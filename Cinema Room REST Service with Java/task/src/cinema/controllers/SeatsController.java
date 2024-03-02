package cinema.controllers;

import cinema.CinemaRoom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SeatsController {
    CinemaRoom cinemaRoom = new CinemaRoom(9, 9);

    @GetMapping("/seats")
    public CinemaRoom getSeats() {
        return cinemaRoom;
    }
}