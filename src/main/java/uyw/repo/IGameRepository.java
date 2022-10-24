package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uyw.model.Media;
import uyw.model.Game;

public interface IGameRepository extends JpaRepository<Game, Integer> {
    
    //make custom query to find the last media from this game
    @Query(value = "SELECT * FROM Media m INNER JOIN Medias AS ms ON ms.game_id = m.id WHERE ms.game_id = ?1 ORDER BY m.id DESC LIMIT 1", nativeQuery = true) 
    public Media findLastMedia(String shortcode);
    
    @Query(value = "SELECT * FROM Game g WHERE g.game_code = ?1 ORDER BY g.game_code DESC", nativeQuery = true)
    Game findByShortCode(String sender);
}
