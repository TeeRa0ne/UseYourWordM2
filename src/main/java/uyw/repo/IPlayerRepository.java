package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uyw.model.Player;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    
}
