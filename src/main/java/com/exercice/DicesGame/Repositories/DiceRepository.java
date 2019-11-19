package com.exercice.DicesGame.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exercice.DicesGame.Domains.Dice;
import com.exercice.DicesGame.Domains.Player;

public interface DiceRepository extends CrudRepository<Dice, Long>{
	
}
