package project.planets.services;

import java.util.List;

import org.springframework.data.domain.Page;

import project.planets.dto.PlanetPostDto;
import project.planets.dto.PlanetShowDto;
import project.planets.model.Planet;

public interface PlanetService {
	
	public List<Planet> findAllSorted(Integer pageNo, Integer pageSize, String sortBy);
	
	public Page<Planet> findAllFiltered(String name, Integer pageNo, Integer pageSize);

	public Planet createPlanet(PlanetPostDto newPlanet);
	
	public PlanetShowDto findOne(Long planetId);
	
	public Planet updatePlanet(Long planetId, PlanetPostDto newPlanet);
	
	public Planet deletePlanet(Long planetId);
}
