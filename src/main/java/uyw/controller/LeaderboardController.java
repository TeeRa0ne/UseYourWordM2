package uyw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.repo.IGameRepository;
import uyw.repo.IPlayerRepository;
import uyw.repo.IReponseRepository;

@Controller
public class LeaderboardController {

	@Autowired
	private IPlayerRepository repoPlayer;

	@Autowired
	private IReponseRepository repoReponse;

	@Autowired
	private IGameRepository repoGame;

    @GetMapping("/leaderboard")
	public String afficher(@RequestParam String shortcode, Model model) {
		
		//calcul who win
		int idwin = repoReponse.getWinner(repoGame.findByShortCode(shortcode).getId());

		String winner = repoPlayer.getReferenceById(idwin).getUsername();

		model.addAttribute("winner", winner);

		return "Leaderboard";
	}
} 