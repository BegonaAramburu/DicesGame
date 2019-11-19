package com.exercice.DicesGame.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.exercice.DicesGame.Domains.Game;



public interface GameRepository extends CrudRepository<Game, Long>{

	

}
