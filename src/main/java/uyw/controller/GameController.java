package uyw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.Scope;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import uyw.model.Reponse;

import uyw.model.Media;
import uyw.model.Game;
import uyw.model.Player;
import uyw.repo.IGameRepository;
import uyw.repo.IReponseRepository;
import uyw.repo.IPlayerRepository;
import uyw.repo.IMediaRepository;

@Controller
@RequestMapping("/game") // Préfixer tous les mapping
public class GameController {

	@Autowired
	private IReponseRepository repoResponse;
	
	@Autowired
	private IGameRepository repoGame;
	
	@Autowired
    private IMediaRepository repoMedia;
	
	@Autowired
    private IPlayerRepository repoPlayer;

	@GetMapping
	public String game(Model model, @RequestParam String shortcode,@RequestParam int media) {
		List<Media> medias = new ArrayList<Media>();
		Game game = repoGame.findByShortCode(shortcode);

		if(media == 3) {
			return "redirect:/vote/wait?shortcode=" + shortcode + "&action=vote";
		}

		if(repoGame.findByShortCode(shortcode) != null) {
			for (int i = 0; i < 3; i++) {	
				Media mediatmp = new Media();
	
				// generate one media for the game
				mediatmp = randomMedia();
				
				// save media and get db id
				medias.add(mediatmp);
			}

			game.setMedias(medias);
			repoGame.save(game);
		}

		Media mediaDisplay = game.getMedias().get(media);

		game.setMedias(medias);
		model.addAttribute("media", mediaDisplay);
		
		return "Game";
	}
	
	@PostMapping
	public String doPost(@RequestParam String shortcode, @RequestParam String answer, @RequestParam String username, Model model, @RequestParam int media) {
		//get from anwser
		Reponse reponse = new Reponse();
		Game game = repoGame.findByShortCode(shortcode);

		Player player = repoPlayer.findUserInGame(username, shortcode);
		reponse.setPlayer(player);
		
		reponse.setMedia(game.getMedias().get(media));
		reponse.setGame(game);
		reponse.setVote(0);
		reponse.setTour(media);

		reponse.setReponse(answer);

		repoResponse.save(reponse);

		return "redirect:/game?shortcode=" + shortcode + "&media=" + (media + 1)  + "&username=" + username;
	}	

	public Media randomMedia() {
        List<Media> medias = this.repoMedia.findAll();
        Random rand = new Random();
        int randomIndex = rand.nextInt(medias.size());
        return medias.get(randomIndex);
    }
}
