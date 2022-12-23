package com.amghar.gamesandticketsservices.services.Game;

import com.amghar.gamesandticketsservices.dtos.inputDtos.GameInputDto;
import com.amghar.gamesandticketsservices.dtos.outputDtos.GameOutputDto;
import com.amghar.gamesandticketsservices.exceptions.custome.InvalidTicketsNumberException;
import com.amghar.gamesandticketsservices.exceptions.custome.MissingFieldsException;

import java.util.List;

public interface GameServices {
    GameOutputDto createGame(GameInputDto gameInputDto) throws MissingFieldsException, InvalidTicketsNumberException;
    List<GameOutputDto> gamesList();
}
