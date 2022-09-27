package uyw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uyw.model.Player;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class PlayerController {

  private List<Player> player = new ArrayList<Player>();
	
	@GetMapping
	public String player() {
		return "Player";
	}
  

}