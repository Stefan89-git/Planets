package project.planets.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import project.planets.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

	Page<Planet> findAllByNameIgnoreCaseContains(String name,Pageable pageable);
}
