package com.amghar.gamesandticketsservices.exceptions.custome;

public class TicketsSoldOutException extends Exception{
    public TicketsSoldOutException(){
        super("Tickets For this Game are Sold Out!!!");
    }
}
