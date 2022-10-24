package uyw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import uyw.model.Player;
import uyw.model.Reponse;
import uyw.repo.IGameRepository;
import uyw.repo.IPlayerRepository;
import uyw.repo.IReponseRepository;

@Controller
public class VoteController {
	
	@Autowired
	private IReponseRepository repoReponse;
	
	@Autowired
	private IGameRepository repoGame;

	@GetMapping("/vote")
	public String afficher(Model model, @RequestParam String shortcode, @RequestParam int media) {

		if(media == 3) {
			return "redirect:/vote/wait?shortcode=" + shortcode + "&action=leaderboard";
		}

		List<Reponse> reponses = repoReponse.getAllForVote(shortcode, media);

		model.addAttribute("reponse", reponses);
		model.addAttribute("shortcode", shortcode);
		model.addAttribute("tour", media);
		model.addAttribute("media", repoGame.findByShortCode(shortcode).getMedias().get(media));
		return "vote";
	}

	@GetMapping("/addVote")
	public String ajouter(@RequestParam int id, HttpSession session, @RequestParam String shortcode, @RequestParam int media) {
		Reponse reponse = this.repoReponse.findById(id).get();
		reponse.setVote(reponse.getVote() + 1);
		this.repoReponse.save(reponse);
		
		//redirect to vote page
		return "redirect:/vote?shortcode="+shortcode+"&media="+ (media + 1);
	}
} 