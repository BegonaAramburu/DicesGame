package com.exercice.DicesGame.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.DicesGame.Domains.Player;
import com.exercice.DicesGame.Repositories.PlayerRepository;




//@CrossOrigin(origins="http://*")
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	

	@PostMapping("/players")
	public String postPlayer(@RequestBody Player player){
		if(player.getPlayerName()=="") {
			player.setPlayerName("anonymous");
			playerRepository.save(player);//salvo el player en el repositorio
			return "Player registrated as anonymous";
		}else {
			playerRepository.save(player);
			List<Player> mismoNombre = new ArrayList<Player>();
			mismoNombre = playerRepository.findByPlayerName(player.getPlayerName());
			if(mismoNombre.size()>1) {
				playerRepository.delete(player);
				return "This name already exists";
			}else {
				playerRepository.save(player);
				return "Player registrated";
			}
		}		
	}
		
	@GetMapping("/players/{playerId}")
	public Player getPlayer(@PathVariable Long playerId) {
		return playerRepository.findByPlayerId(playerId);
	}
	
	@GetMapping("/players")
	public List<Player> getAllPlayers(){
		return (List<Player>) playerRepository.findAll();
	}
	
	@PutMapping("/players")
	public Player putPlayer(@RequestBody Player player) {
		postPlayer(player);
		return player;
	}
	
	@DeleteMapping("/players/{playerId}")
	public String deletePlayer(@PathVariable Long playerId){
		playerRepository.deleteById(playerId);
		return "Player deleted";
	}	

}
