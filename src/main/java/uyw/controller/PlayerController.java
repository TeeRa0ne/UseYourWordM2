package uyw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.model.Game;
import uyw.model.Player;
import uyw.repo.IGameRepository;
import uyw.repo.IPlayerRepository;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/players")

public class PlayerController {
	@Autowired
	private IPlayerRepository repoPlayer;
	
	@Autowired
	private IGameRepository repoGame;

	@PostMapping
	public String addPlayer(@RequestParam String name, Model model, HttpSession session) {
		List<Player> players = new ArrayList<Player>();
		
		if(session.getAttribute("error") != null) {
			model.addAttribute("error", session.getAttribute("error"));
			session.removeAttribute("error");
		} else {
			model.addAttribute("error", "");
		}
		
		if(session.getAttribute("Players") != null) {

			//TODO : Fix caste
			players = (List<Player>)session.getAttribute("Players");
		}

		Player player = new Player(name);
		model.addAttribute("players", players);
		if (name == null || name.isEmpty()) {
			model.addAttribute("error", "Pseudo requis.");
		} else {

			//TODO : check if player already exists
			players.add(player);
			player.setUsername(name);
			repoPlayer.save(player);
		}


		session.setAttribute("Players", players);
		return "Player";
	}


	@GetMapping("/go")
	public String startNewGame(HttpSession session) {
		if (session.getAttribute("Players") == null) {
			session.setAttribute("error", "Il faut au moins un joueur.");
			return "redirect:/players";
		}

		Game game = new Game();
	
		//TODO : Fix caste
		game.setPlayers((List<Player>)session.getAttribute("Players"));

		// save game and get db id		
		session.setAttribute("gameId", this.repoGame.save(game).getId());
		session.removeAttribute("Players");
		return "redirect:/game";
	}

	@GetMapping
	public String player(@RequestParam("id") Optional<String> param, Model model) {
		if (param == null || param.isEmpty()) {
			//random number letter
			String slug = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";	
			String name = "";
			for (int i = 0; i < 5; i++) {
				name += slug.charAt((int)(Math.random() * slug.length()));
			}

			model.addAttribute("gameId", name);
			return "redirect:/players?id=" + name;
		}
		
		model.addAttribute("gameId", param.get());
		return "Player";
	}
}