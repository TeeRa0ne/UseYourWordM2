package uyw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.servlet.http.*;

import uyw.model.Game;
import uyw.model.Player;
import uyw.model.SocketMessage;
import uyw.repo.IGameRepository;
import uyw.repo.IPlayerRepository;
import org.springframework.context.annotation.Scope;

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
        Game game = repoGame.findByShortCode(socMes.getSender());      

        if (game == null) {
            game = new Game();
            game.setShortcode(socMes.getSender());
            repoGame.save(game);
        } else {
            game = repoGame.findByShortCode(socMes.getSender());
        }

        // add player to game
        Player player = new Player();
        player.setUsername(socMes.getContent());
        repoPlayer.save(player);
        
        if (game.getPlayers() == null) {
            game.setPlayers(List.of(player));
        } else {
            List<Player> players = new ArrayList<Player>(game.getPlayers());
            
            players.add(player);
            game.setPlayers(players);
        }
        repoGame.save(game);

        simpMessagingTemplate.convertAndSend("/topic/player/" + socMes.getSender(), socMes);
    }

    @MessageMapping("/player/startGame")
    public void startGame(@Payload SocketMessage socMes, SimpMessageHeaderAccessor headerAccessor) {
        simpMessagingTemplate.convertAndSend("/topic/player/" + socMes.getSender(), socMes);
    }

    @MessageMapping("/wait/waitPlayer")
    public void waitPlayer(@Payload SocketMessage socMes, SimpMessageHeaderAccessor headerAccessor) {
        simpMessagingTemplate.convertAndSend("/topic/wait/" + socMes.getSender(), socMes);
    }
}