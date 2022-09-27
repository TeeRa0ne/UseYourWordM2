package uyw.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uyw.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    
}
