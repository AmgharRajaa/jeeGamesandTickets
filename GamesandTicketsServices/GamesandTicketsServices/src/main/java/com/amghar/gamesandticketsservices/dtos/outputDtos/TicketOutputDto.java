package com.amghar.gamesandticketsservices.dtos.outputDtos;

import com.amghar.gamesandticketsservices.enums.TicketState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOutputDto {
    private String id;
    private Double price;
    private TicketState state;
    private String ref;
    private GameOutputDto gameOutputDto;
}
