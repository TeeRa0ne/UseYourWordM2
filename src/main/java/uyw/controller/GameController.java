package uyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game") // Préfixer tous les mapping
public class GameController {
	
	@GetMapping
	public String game() {		
		return "Game";
	}
	
	@PostMapping
	public String doPost() {
		
		
		return "Game";
	}
	
}
