package uyw.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.dto.MediaDto;
import uyw.model.Media;
import uyw.model.Reponse;
import uyw.repo.IPlayerRepository;
import uyw.repo.IReponseRepository;

@Controller
@RequestMapping("/game") // Préfixer tous les mapping
public class GameController {

	@Autowired
	private IReponseRepository repoResponse;
	
	@GetMapping
	public String game(Model model) {

		// Afficher un media (image, video, texte)
		MediaDto mediaDto = new MediaDto();
		mediaDto.setMedia(Media.values()[new Random().nextInt(Media.values().length)]);


		switch (mediaDto.getMedia()) {
			case IMAGE:
				mediaDto.setUrl("https://unsplash.it/600");
				break;
			case VIDEO:
				mediaDto.setUrl("https://www.youtube.com/embed/xvFZjo5PgG0");
				break;
			case TEXTE:
				mediaDto.setUrl("https://www.lipsum.com/");
				break;
			default:
				break;
		}

		model.addAttribute("media", mediaDto);
		
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
