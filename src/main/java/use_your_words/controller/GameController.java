package use_your_words.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game") // Préfixer tous les mapping
public class GameController {
	
	public String doGet(HttpSession session, Model model) {		
		return "game";
	}
	
	public String doPost() {
		return "game";
	}

}
