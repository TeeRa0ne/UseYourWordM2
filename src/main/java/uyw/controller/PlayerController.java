package uyw.controller;

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

@Controller
@RequestMapping("/players")
public class PlayerController {
	@Autowired
	private IGameRepository repoGame;

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

		return "redirect:/game?shotcode=" + session.getAttribute("gameId");
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