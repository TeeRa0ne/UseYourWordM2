package uyw.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.model.EMedia;
import uyw.model.Reponse;

import uyw.model.Media;
import uyw.repo.IGameRepository;
import uyw.repo.IReponseRepository;

@Controller
@RequestMapping("/game") // Préfixer tous les mapping
public class GameController {

	@Autowired
	private IReponseRepository repoResponse;
	
	@Autowired
	private IGameRepository repoGame;

	@GetMapping
	public String game(Model model, @RequestParam String shortcode) {
		Media media = repoGame.findLastMedia(shortcode);
		model.addAttribute("media", media);
		
		return "Game";
	}
	
	@PostMapping
	public String doPost(@RequestParam String answer, Model model) {
		model.addAttribute("answer", answer);
		if (answer == null || answer.isEmpty()) {
			return "Game";
		} else {
			Reponse response = new Reponse(answer);
			this.repoResponse.save(response);
			return "Game";
		}
	}	
}
