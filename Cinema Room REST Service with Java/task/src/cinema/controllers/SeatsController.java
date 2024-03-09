package cinema.controllers;

import cinema.Seat;
import cinema.services.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class SeatsController {
    private final SeatService seatService;

    public SeatsController(SeatService seatService) {
        this.seatService = seatService;
    }
    
    @GetMapping("/seats")
    public ResponseEntity<Object> getSeats() {
        return new ResponseEntity<>(Map.of("rows", seatService.getCinemaRoom().getRows(),
                "columns", seatService.getCinemaRoom().getColumns(),
                "seats", seatService.getCinemaRoom().getSeats()), HttpStatus.OK);
    }


        @PostMapping("/purchase")
        public ResponseEntity<Object> purchaseSeat(@RequestBody Map<String, Integer> payload) {
            int row = payload.get("row");
            int column = payload.get("column");

            if (row > seatService.getCinemaRoom().getRows() || column > seatService.getCinemaRoom().getColumns() || row < 1 || column < 1) {
                return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
            }

            for (Seat seat : seatService.getCinemaRoom().getSeats()) {
                if (seat.getRow() == row && seat.getColumn() == column) {
                    if (seat.isPurchased()) {
                        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
                    } else {
                        seat.setPurchased(true);
                        return new ResponseEntity<>(Map.of("row", row, "column", column, "price", seat.getPrice()), HttpStatus.OK);
                    }
                }
            }

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
