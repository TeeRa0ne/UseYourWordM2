package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uyw.model.Vote;

public interface IPlayerRepository extends JpaRepository<Vote, Integer> {
    
}
