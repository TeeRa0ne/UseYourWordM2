package uyw.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import uyw.model.Media;

public interface IMediaRepository extends JpaRepository<Media, Integer> {
    
}