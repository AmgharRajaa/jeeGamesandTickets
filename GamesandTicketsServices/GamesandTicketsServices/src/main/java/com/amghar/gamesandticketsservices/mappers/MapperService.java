package com.amghar.gamesandticketsservices.mappers;

import com.amghar.gamesandticketsservices.dtos.outputDtos.GameOutputDto;
import com.amghar.gamesandticketsservices.dtos.outputDtos.TicketOutputDto;
import com.amghar.gamesandticketsservices.entities.Game;
import com.amghar.gamesandticketsservices.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public GameOutputDto fromGame(Game game){
        GameOutputDto gameOutputDto = new GameOutputDto();
        BeanUtils.copyProperties(game, gameOutputDto);
        return  gameOutputDto;
    }

    public TicketOutputDto fromTicket(Ticket ticket){
        TicketOutputDto ticketOutputDto = new TicketOutputDto();
        BeanUtils.copyProperties(ticket, ticketOutputDto);
        ticketOutputDto.setGameOutputDto(this.fromGame(ticket.getGame()));
        return ticketOutputDto;
    }
}
