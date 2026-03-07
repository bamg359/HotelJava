package application.domain;

import application.domain.enums.StatusBooking;

import java.time.LocalDate;

public class Booking {

    private long id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private StatusBooking statusBooking;

// constructor


    public Booking(long id, LocalDate checkIn, LocalDate checkOut, StatusBooking statusBooking) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.statusBooking = statusBooking;
    }


// methods


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public StatusBooking getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(StatusBooking statusBooking) {
        this.statusBooking = statusBooking;
    }
}


