package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uyw.model.Game;

public interface IGameRepository extends JpaRepository<Game, Integer> {
    
}
