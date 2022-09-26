package use_your_words.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vote")
public class VoteController {
	@GetMapping
	public String login() {
		return "vote";
	}
} 