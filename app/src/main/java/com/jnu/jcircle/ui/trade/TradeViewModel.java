package com.jnu.jcircle.ui.trade;

import java.io.Serializable;

public class TradeViewModel implements Serializable {
    private String ticketType;
    private String ticketState;
    private String ticketIncome;
    private String ticketLocation;
    private String ticketDuration;
    private String ticketPicture;

    public TradeViewModel(String ticketType, String ticketState, String ticketIncome, String ticketLocation, String ticketDuration, String ticketPicture) {
        this.ticketType = ticketType;
        this.ticketState = ticketState;
        this.ticketIncome = ticketIncome;
        this.ticketLocation = ticketLocation;
        this.ticketDuration = ticketDuration;
        this.ticketPicture = ticketPicture;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
    }

    public String getTicketIncome() {
        return ticketIncome;
    }

    public void setTicketIncome(String ticketIncome) {
        this.ticketIncome = ticketIncome;
    }

    public String getTicketLocation() {
        return ticketLocation;
    }

    public void setTicketLocation(String ticketLocation) {
        this.ticketLocation = ticketLocation;
    }

    public String getTicketDuration() {
        return ticketDuration;
    }

    public void setTicketDuration(String ticketDuration) {
        this.ticketDuration = ticketDuration;
    }

    public String getTicketPicture() {
        return ticketPicture;
    }

    public void setTicketPicture(String ticketPicture) {
        this.ticketPicture = ticketPicture;
    }
}
