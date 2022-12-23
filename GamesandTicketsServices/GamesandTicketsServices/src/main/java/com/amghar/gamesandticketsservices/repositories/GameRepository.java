package com.amghar.gamesandticketsservices.repositories;

import com.amghar.gamesandticketsservices.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
