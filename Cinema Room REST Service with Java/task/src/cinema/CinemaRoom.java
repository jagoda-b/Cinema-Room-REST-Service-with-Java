package cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    int rows;
    int columns;
    List<Seat> seats;

    public CinemaRoom(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                int price = i <= 4 ? 10 : 8;
                seats.add(new Seat(i, j, price));
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getAvailableSeats() {
        return seats.stream().filter(seat -> !seat.isPurchased()).toList();
    }

    public Seat getSeat(int row, int column) {
        return seats.stream().filter(seat -> seat.getRow() == row && seat.getColumn() == column).findFirst().orElse(null);
    }

    public void purchaseSeat(int row, int column) {
        seats.stream().filter(seat -> seat.getRow() == row && seat.getColumn() == column).findFirst().ifPresent(seat -> seat.setPurchased(true));
    }
}
