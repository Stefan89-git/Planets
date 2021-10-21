package project.planets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.planets.model.Planet;
import project.planets.model.Satellite;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

	public List<Satellite> findByPlanet(Planet planet);
}
