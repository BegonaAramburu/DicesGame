package com.exercice.DicesGame.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exercice.DicesGame.Domains.Player;

public interface PlayerRepository extends CrudRepository<Player,Long>{

	public List<Player> findByPlayerName(String playerName);
	public Player findByPlayerId(Long playerId);
	

}
