package com.exercice.DicesGame.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.DicesGame.Domains.Dice;
import com.exercice.DicesGame.Domains.Game;
import com.exercice.DicesGame.Repositories.DiceRepository;
import com.exercice.DicesGame.Repositories.GameRepository;

@RestController
public class GameController {
	
	@Autowired
	DiceRepository diceRepository;
		
	@Autowired
	GameRepository gameRepository;
	
	@PostMapping("/games/dices/{numDices}")
	public String postGame(@PathVariable Integer numDices, @RequestBody Dice dice) {
		Game game = new Game(numDices);
		gameRepository.save(game);
		for(int i=0; i<numDices; i++) {
			diceRepository.save(dice);
		}
		
		return numDices + " dices created";
		
	}

}
