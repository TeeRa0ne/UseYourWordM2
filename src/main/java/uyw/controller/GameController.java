package uyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/game") // Préfixer tous les mapping
public class GameController {
	
	@GetMapping
	public String game(@RequestParam String name, Model model) {

		//Recuperer les joueurs et les faire défiler au fil des tours 

		
		
	

		

		return "Game";
	}
	
	@PostMapping
	public String doPost() {
		

		
		return "Game";
	}
	
}
