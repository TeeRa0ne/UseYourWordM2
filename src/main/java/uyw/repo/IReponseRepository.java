package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uyw.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Integer> {
    
}
