package com.exercice.DicesGame.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.DicesGame.Domains.Dice;
import com.exercice.DicesGame.Repositories.DiceRepository;


@RestController
public class DicesController {
	
	@Autowired
	DiceRepository diceRepository;
	
	@PostMapping("/dices")
	public String postDice(@RequestBody Dice dice) {
		diceRepository.save(dice);
		return "dice saved";
	}
	
	@GetMapping("/dices")
	public List<Dice> getAllDices(){
		return (List<Dice>) diceRepository.findAll();
	}
	
	
	/*@GetMapping("/dices/{diceId}")
	public Integer getDiceById(@PathVariable Long diceId, Dice dice){
		dice.setFace();
		diceRepository.save(dice);
		return dice.getFace();
	}*/
	
	@DeleteMapping("/dices")
	public String deleteDices() {
		diceRepository.deleteAll();
		return "Dices deleted";
	}
	
	
	
	

}
