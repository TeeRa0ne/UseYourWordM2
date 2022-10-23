package uyw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.model.Player;
import uyw.model.Reponse;
import uyw.repo.IPlayerRepository;
import uyw.repo.IReponseRepository;

@Controller
public class VoteController {
	
	@Autowired
	private IReponseRepository repoReponse;

	//TODO : Remplacer le paramètre par la valeur de la session
	@Autowired
	private IPlayerRepository repoPlayer;

	@GetMapping("/vote")
	public String afficher(Model model) {
		if (repoPlayer.count() == 0) {
			for(int i = 0; i < 10; i++) {
				Reponse reponse = new Reponse();
	
				//TODO : Remplacer le paramètre par la valeur de la session
				Player player = new Player();
				player.setUsername(("Alexis" + i));
				this.repoPlayer.save(player);
		
				reponse.setReponse("La réponse" + i);
		
				reponse.setPlayer(player);
				this.repoReponse.save(reponse);
			}
		}

		model.addAttribute("reponse", this.repoReponse.findAll());
		return "Vote";
	}

	@GetMapping("/addVote")
	public String ajouter(@RequestParam int id, HttpSession session) {
		Reponse reponse = this.repoReponse.findById(id).get();
		reponse.setVote(reponse.getVote() + 1);
		this.repoReponse.save(reponse);

		session.setAttribute("vote", true);
		
		//redirect to vote page
		return "redirect:/vote";
	}
} 