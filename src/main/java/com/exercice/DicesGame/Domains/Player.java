package com.exercice.DicesGame.Domains;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

import org.springframework.data.annotation.CreatedDate;


@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long playerId;
	private String playerName;
	private Date altaRegistro;
   
	//private List<Game> gameList;
	//private Double succesRate;
	
	/*@OneToMany
	@JoinColumn(name = "game_gameId")
	private Game game;*/
	
	public Player() {
		
		altaRegistro = new Date();

	}
	
	//public Player(String playerName, Data playerRegistro, List<Game> gameList, Double succesRate) {
	public Player(String playerName) {	
		altaRegistro = new Date();
		/*//this.gameList = gameList;
		this.succesRate = succesRate;*/
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Date getAltaRegistro() {
		return altaRegistro;
	}

	public void setAltaRegistro(Date altaRegistro) {
		this.altaRegistro = altaRegistro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}

	/*public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	*/
	
	
	/*public List<Game> getGameList() {
		return gameList;
	}
	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}
	public Double getSuccesRate() {
		return succesRate;
	}
	public void setSuccesRate(Double succesRate) {
		this.succesRate = succesRate;
	}*/

	
	
	
}
