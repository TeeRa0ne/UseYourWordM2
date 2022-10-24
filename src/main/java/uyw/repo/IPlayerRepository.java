package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uyw.model.Player;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    // find player by username and game shortcode
    @Query(value = "SELECT * FROM player p INNER JOIN players AS ps ON ps.player_id = p.player_id INNER JOIN game AS g ON g.game_id = ps.game_id WHERE p.player_name = ?1 AND g.game_code = ?2", nativeQuery = true)
    Player findUserInGame(String username, String game);
}
