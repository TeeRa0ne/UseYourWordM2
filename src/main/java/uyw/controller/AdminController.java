package uyw.controller;

import uyw.model.EMedia;
import uyw.model.Media;
import uyw.repo.IMediaRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private static final String REDIRECT_LIST = "redirect:/admin";

  @Autowired
	private IMediaRepository repoMedia;

  @GetMapping
	public String findAll(Model model) {
		model.addAttribute("medias", this.repoMedia.findAll());
		
		return "admin/list";
	}

	@GetMapping("/add")
	public String add() {
		return "admin/edit";
	}

	@PostMapping("/add")
	public String add(@RequestParam EMedia type, @RequestParam String url, Media argMedia) {
		Media media2 = new Media();
		
		media2.setMedia(type);
    media2.setUrl(url);
		this.repoMedia.save(media2);

		return REDIRECT_LIST;
	}

  @GetMapping("/edit")
	public String edit(@RequestParam int id, Model model) {
		Optional<Media> optMedia = this.repoMedia.findById(id);
		
		if (optMedia.isPresent()) {
			model.addAttribute("media", optMedia.get());
			return "admin/edit";
		}
		
		return REDIRECT_LIST;
	}
	
	@PostMapping("/edit")
	public String edit(@RequestParam int id, Media argMedia) {
		Optional<Media> optMedia = this.repoMedia.findById(id);
		
		if (optMedia.isPresent()) {
			optMedia.get().setMedia(argMedia.getMedia());
      optMedia.get().setUrl(argMedia.getUrl());

			this.repoMedia.save(optMedia.get());
		}
		
		return REDIRECT_LIST;
	}
	

  @GetMapping("/delete")
	public String deleteById(@RequestParam int id) {
		this.repoMedia.deleteById(id);
		
		return REDIRECT_LIST;
	}
  
}
