package cinema.services;

import cinema.CinemaRoom;
import cinema.Seat;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    private final CinemaRoom cinemaRoom = new CinemaRoom(9, 9);

    public Seat getSeat(int row, int column) {
        return cinemaRoom.getSeat(row, column);
    }

    public void purchaseSeat(int row, int column) {
        cinemaRoom.purchaseSeat(row, column);
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }
}