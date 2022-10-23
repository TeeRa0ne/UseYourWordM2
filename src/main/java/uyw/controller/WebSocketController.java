package uyw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.Random;

import uyw.model.Game;
import uyw.model.Player;
import uyw.model.Media;
import uyw.model.SocketMessage;
import uyw.model.EMedia;
import uyw.repo.IGameRepository;
import uyw.repo.IPlayerRepository;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
	private IGameRepository repoGame;

    @Autowired
	private IPlayerRepository repoPlayer;
    
    @MessageMapping("/player/addUser")
    public void addUser(@Payload SocketMessage socMes, SimpMessageHeaderAccessor headerAccessor) {
        // create game if not exist with this shortcode
        // Game game = repoGame.findByShortCode(socMes.getSender());
        // if (game == null) {
        //     game = new Game();
        //     game.setShortcode(socMes.getSender());
        //     repoGame.save(game);
        // }

        // add player to game
        // Player player = new Player();
        // player.setUsername(socMes.getContent());
        // repoPlayer.save(player);
        
        // game.setPlayers(List.of(player));
        // repoGame.save(game);

        // //add new media to game
        // Media media = getNewMedia();
        // game.setMedias(List.of(media));
        // repoGame.save(game);

        simpMessagingTemplate.convertAndSend("/topic/player/" + socMes.getSender(), socMes);
    }

    @MessageMapping("/player/startGame")
    public void startGame(@Payload SocketMessage socMes, SimpMessageHeaderAccessor headerAccessor) {

        simpMessagingTemplate.convertAndSend("/topic/player/" + socMes.getSender(), socMes);
    }

    public static Media getNewMedia() {

		Media media = new Media();
		media.setMedia(EMedia.values()[new Random().nextInt(EMedia.values().length)]);

		switch (media.getMedia()) {
			case IMAGE:
				media.setUrl("https://unsplash.it/600");
				break;
			case VIDEO:
				media.setUrl("https://www.youtube.com/embed/xvFZjo5PgG0");
				break;
			case TEXTE:
				media.setUrl("https://www.lipsum.com/");
				break;
			default:
				break;
		}

		return media;
	}

}