package com.amghar.gamesandticketsservices.services.Ticket;

import com.amghar.gamesandticketsservices.dtos.inputDtos.TicketInputDto;
import com.amghar.gamesandticketsservices.dtos.outputDtos.TicketOutputDto;
import com.amghar.gamesandticketsservices.exceptions.custome.*;


public interface TicketServices {
    TicketOutputDto buyTicket(TicketInputDto ticketInputDto) throws MissingFieldsException, GameIdNotFoundException, TicketsSoldOutException;

    void validateTicket(String id) throws TicketIdNotFoundException, TicketAlreadyValidatedException;
}
