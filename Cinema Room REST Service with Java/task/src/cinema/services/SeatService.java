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

    public Seat purchaseSeat(int row, int column) {
        Seat seat = cinemaRoom.getSeat(row, column);
        seat.setPurchased(true);
        return seat;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public Seat returnSeat(String token) {
        return cinemaRoom.returnSeat(token);
    }
}