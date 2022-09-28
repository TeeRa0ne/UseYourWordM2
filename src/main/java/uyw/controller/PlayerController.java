package uyw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.model.Player;
import uyw.repo.IPlayerRepository;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/players")
public class PlayerController {
	List<Player> players = new ArrayList<Player>();

	@Autowired
	private IPlayerRepository repoPlayer;

	@PostMapping
	public String addPlayer(@RequestParam String name, Model model) {
		Player player = new Player(name);
		model.addAttribute("players", players);
		if (name == null || name.isEmpty()) {
			model.addAttribute("error", "Pseudo requis.");
			return "Player";
		} else {
			players.add(player);
			player.setUsername(name);
			this.repoPlayer.save(player);
			return "Player";
		}
	}

	@GetMapping
	public String player() {
		return "Player";
	}
}