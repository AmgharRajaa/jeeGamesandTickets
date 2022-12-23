package com.amghar.gamesandticketsservices.web;

import com.amghar.gamesandticketsservices.exceptions.custome.InvalidTicketsNumberException;
import com.amghar.gamesandticketsservices.exceptions.custome.MissingFieldsException;
import com.amghar.gamesandticketsservices.dtos.inputDtos.GameInputDto;
import com.amghar.gamesandticketsservices.dtos.outputDtos.GameOutputDto;
import com.amghar.gamesandticketsservices.services.Game.GameServices;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GameGraphqlController {
    private GameServices gameServices;

    @MutationMapping
    private GameOutputDto addGame(@Argument GameInputDto gameInputDto) throws MissingFieldsException, InvalidTicketsNumberException {
        return gameServices.createGame(gameInputDto);
    }

    @QueryMapping
    private List<GameOutputDto> getGames(){
        return gameServices.gamesList();
    }
}
