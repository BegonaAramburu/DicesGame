package com.exercice.DicesGame.Domains;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Dice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long diceId;
	private Integer face;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
    private Game game;
	
	public Dice() {
		face= (int) Math.floor(Math.random()*6+1);
			}
	
	//-----------------------------------------setters y getters----------------------------------------------
	public Long getDiceId() {
		return diceId;
	}
	public void setDiceId(Long diceId) {
		this.diceId = diceId;
	}
	public Integer getFace() {
		return face;
	}
	public void setFace() {
		face= (int) Math.floor(Math.random()*6+1);
		
	}
	
	
	
	
	
	
	
	

	

	
	
	/*public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}*/

	

}
