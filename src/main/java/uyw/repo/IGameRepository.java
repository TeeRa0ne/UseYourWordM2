package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uyw.model.Game;
import uyw.model.Media;

public interface IGameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT m FROM Media m INNER JOIN Medias AS ms ON ms.game_id = m.id WHERE ms.game_id = (select g from Game g where g.player.shortcode = ?1 LIMITE 1) ORDER BY m.id DESC LIMIT 1")
    Media findLastMedia(String shortcode);

    @Query("SELECT g FROM Game g WHERE g.shortcode = :id ORDER BY g.id DESC")
    Game findByShortCode(String sender);
    
}
