package com.cancelticket.exception;
public class TicketReservationException extends RuntimeException {
    public TicketReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}
