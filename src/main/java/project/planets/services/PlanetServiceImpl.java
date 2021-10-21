package project.planets.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import project.planets.dto.PlanetPostDto;
import project.planets.dto.PlanetShowDto;
import project.planets.dto.SatelliteShowDto;
import project.planets.model.Planet;
import project.planets.model.Satellite;
import project.planets.repositories.PlanetRepository;
import project.planets.repositories.SatelliteRepository;
import project.planets.utils.Validation;

@Service
public class PlanetServiceImpl implements PlanetService{
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private SatelliteRepository satelliteRepository;
	
	@Override
	public Planet createPlanet(PlanetPostDto planetPostDto) {
		Planet planet = planetPostDto.toEntity(planetPostDto);
		planet.setActive(true);
		return planetRepository.save(planet);
	}
	
	@Override
	public Page<Planet> findAllFiltered(String name, Integer pageNo, Integer pageSize) {
		
		return planetRepository.findAllByNameIgnoreCaseContains(name, PageRequest.of(pageNo, pageSize));
	}

	
	@Override
	public List<Planet> findAllSorted(Integer pageNo, Integer pageSize, String sortBy) {
		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		
		Page<Planet> pagedResult =  (Page<Planet>) planetRepository.findAll(paging);
		
		if(pagedResult.hasContent()) {
	            return pagedResult.getContent().stream().distinct().collect(Collectors.toList());
	        } else {
	            return new ArrayList<Planet>();
	        }
	}

	@Override
	public PlanetShowDto findOne(Long planetId) {
		Optional<Planet> optionalPlanet = planetRepository.findById(planetId);
		if(!optionalPlanet.isPresent()) {
			return null;
		}
		Planet planet = optionalPlanet.get();
		PlanetShowDto planetShow = new PlanetShowDto(planet);
		List<Satellite> satellites = planet.getSatellites();
		List<SatelliteShowDto> satellitesShow = new ArrayList<>();
		for(Satellite s : satellites) {
			SatelliteShowDto ssd = new SatelliteShowDto(s);
			satellitesShow.add(ssd);
		}
		planetShow.setSatellites(satellitesShow);
		return planetShow;
		
	}

	@Override
	public Planet updatePlanet(Long planetId, PlanetPostDto planetPostDto) {
		Optional<Planet> optionalPlanet = planetRepository.findById(planetId);
		if(!optionalPlanet.isPresent()) {
			return null;
		}
		Planet planet = optionalPlanet.get();
		planet.setName(Validation.setIfNotNull(planet.getName(), planetPostDto.getName()));
		planet.setSurfaceArea(Validation.setIfNotNull(planet.getSurfaceArea(), planetPostDto.getSurfaceArea()));
		planet.setMass(Validation.setIfNotNull(planet.getMass(), planetPostDto.getMass()));
		planet.setDistanceFromSun(Validation.setIfNotNull(planet.getDistanceFromSun(), planetPostDto.getDistanceFromSun()));
		planet.setAverageSurfaceTemperature(Validation.setIfNotNull(planet.getAverageSurfaceTemperature(), 
											planetPostDto.getAverageSurfaceTemperature()));
		return planetRepository.save(planet);
	}

	@Override
	public Planet deletePlanet(Long planetId) {
		Optional<Planet> optionalPlanet = planetRepository.findById(planetId);
		if(!optionalPlanet.isPresent()) {
			return null;
		}
		Planet planet = optionalPlanet.get();
		planet.setActive(false);
		List<Satellite> satellits = planet.getSatellites();
		for(Satellite s : satellits) {
			satelliteRepository.delete(s);
		}
		planet.setSatellites(new ArrayList<>());
		return planetRepository.save(planet);
	}
	

}
