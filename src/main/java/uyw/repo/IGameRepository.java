package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uyw.model.Media;
import uyw.model.Game;

public interface IGameRepository extends JpaRepository<Game, Integer> {
    
    //make custom query to find the last media from this game
    @Query(value = "SELECT m FROM Media m INNER JOIN Medias AS ms ON ms.game_id = m.id WHERE ms.game_id = (select g from Game g where g.player.shortcode = ?1 LIMITE 1) ORDER BY m.id DESC LIMIT 1", nativeQuery = true) 
    public Media findLastMedia(String shortcode);

}
