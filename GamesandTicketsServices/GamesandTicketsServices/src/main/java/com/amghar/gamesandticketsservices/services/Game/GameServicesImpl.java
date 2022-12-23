package com.amghar.gamesandticketsservices.services.Game;

import com.amghar.gamesandticketsservices.dtos.inputDtos.GameInputDto;
import com.amghar.gamesandticketsservices.dtos.outputDtos.GameOutputDto;
import com.amghar.gamesandticketsservices.entities.Game;
import com.amghar.gamesandticketsservices.exceptions.custome.InvalidTicketsNumberException;
import com.amghar.gamesandticketsservices.exceptions.custome.MissingFieldsException;
import com.amghar.gamesandticketsservices.mappers.MapperService;
import com.amghar.gamesandticketsservices.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class GameServicesImpl implements GameServices {
    private GameRepository gameRepository;
    private MapperService mapperService;

    @Override
    public GameOutputDto createGame(GameInputDto gameInputDto) throws MissingFieldsException, InvalidTicketsNumberException {
        if (gameInputDto.getDateAndTime() == null || gameInputDto.getAvailableTickets() == null
        || gameInputDto.getStadium()==null || gameInputDto.getStadium().isEmpty()
        || gameInputDto.getTeam1() == null || gameInputDto.getTeam1().isEmpty()
        || gameInputDto.getTeam2() == null || gameInputDto.getTeam2().isEmpty())
            throw new MissingFieldsException();
        if (gameInputDto.getAvailableTickets() > 2022 || gameInputDto.getAvailableTickets() <= 0)
            throw new InvalidTicketsNumberException(gameInputDto.getAvailableTickets());
        Game game = new Game();
        game.setId(UUID.randomUUID().toString());
        game.setDateAndTime(gameInputDto.getDateAndTime());
        game.setStadium(gameInputDto.getStadium());
        game.setTeam1(gameInputDto.getTeam1());
        game.setTeam2(gameInputDto.getTeam2());
        game.setRef(UUID.randomUUID().toString());
        game.setAvailableTicketNumber(gameInputDto.getAvailableTickets());
        return mapperService.fromGame(gameRepository.save(game));
    }
    @Override
    public List<GameOutputDto> gamesList(){
        return gameRepository.findAll().stream().map(
                g -> mapperService.fromGame(g)
        ).toList();
    }
}
