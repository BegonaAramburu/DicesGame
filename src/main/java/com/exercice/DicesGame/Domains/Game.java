package com.exercice.DicesGame.Domains;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.exercice.DicesGame.Controllers.DicesController;
import com.exercice.DicesGame.Repositories.DiceRepository;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long gameId;
	private Integer gameResult;
	private Boolean gameWinner;
	private Integer numDices;
	
	
	@OneToMany(mappedBy = "game")
	private List<Dice> dices = new ArrayList<Dice>();
	
	
	
	
	//DiceRepository diceRepository;
	
	public Game() {
		
	}
	public Game(Integer numDices) {
		this.numDices = numDices;
		/*for(int i=0; i<numDices;i++) {
			Dice dice = new Dice();
			dices.add(dice);
			//diceRepository.save(dice);
			System.out.println(dice.getFace());
			for(int j=0; j<dices.size(); j++) {
				System.out.println(dices.get(j));
			}
			
		}*/
		
	}
	
	
	public List<Dice> getDices() {
		return dices;
	}
	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}
	public Integer getNumDices() {
		return numDices;
	}
	public void setNumDices(Integer numDices) {
		this.numDices = numDices;
	}
	public void getGameWinner() {
		if (gameWinner) {
			System.out.println("You have won the game");
		}else {
			System.out.println("You have lost the game");
		}
	}
	public void setGameWinner(Boolean gameWinner) {
		if(numDices == 2) {
			if (gameResult == 7) {
				gameWinner = true;
			}else {
				gameWinner = false;
			}
		}
		
	}
	
	public Integer getGameResult() {
		return gameResult;
	}
	public void setGameResult(Integer numDices) {
		/*if(numDices==2) {
			for(int i=0; i<numDices; i++) {
				gameResult += dice.getFace();
			}	
		}*/
		
		
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
		

}
