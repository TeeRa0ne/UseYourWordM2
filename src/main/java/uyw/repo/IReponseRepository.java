package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import uyw.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Integer> {
    @Query(value = "SELECT * FROM reponse r INNER JOIN game AS g ON g.game_id = rep_game WHERE g.game_code = ?1 AND r.rep_tour = ?2", nativeQuery = true)
    List<Reponse> getAllForVote(String gameShortcode, int media);

    @Query(value = "SELECT rep_player AS somme FROM reponse WHERE rep_game = ?1 GROUP BY rep_player ORDER BY somme DESC LIMIT 1", nativeQuery = true)
    int getWinner(int game_id);
}
