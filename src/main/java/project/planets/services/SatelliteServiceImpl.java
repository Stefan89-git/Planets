package project.planets.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.planets.dto.SatellitePostDto;
import project.planets.dto.SatelliteShowDto;
import project.planets.model.Planet;
import project.planets.model.Satellite;
import project.planets.repositories.PlanetRepository;
import project.planets.repositories.SatelliteRepository;
import project.planets.utils.Validation;

@Service
public class SatelliteServiceImpl implements SatelliteService {

	@Autowired
	private SatelliteRepository satelliteRepository;
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@Override
	public Satellite createSatellite(SatellitePostDto satellitePostDto) {
		Satellite satellite = satellitePostDto.toEntity(satellitePostDto);
		Optional<Planet> optionalPlanet = planetRepository.findById(satellitePostDto.getPlanetId());
		if(!optionalPlanet.isPresent()) {
			return null;
		}
		Planet planet = optionalPlanet.get();
		if(!planet.getActive()) {
			return null;
		}
		satellite.setPlanet(planet);
		return satelliteRepository.save(satellite);
	}

	@Override
	public Satellite updateSatellite(Long satelliteId, SatellitePostDto satellitePostDto) {
		Optional<Satellite> optionalSatellite = satelliteRepository.findById(satelliteId);
		if(!optionalSatellite.isPresent()) {
			return null;
		}
		Satellite satellite = optionalSatellite.get();
		satellite.setName(Validation.setIfNotNull(satellite.getName(), satellitePostDto.getName()));
		satellite.setSurfaceArea(Validation.setIfNotNull(satellite.getSurfaceArea(), satellitePostDto.getSurfaceArea()));
		satellite.setMass(Validation.setIfNotNull(satellite.getMass(), satellitePostDto.getMass()));
		satellite.setNaturalSatelitte(Validation.setIfNotNull(satellite.getNaturalSatelitte(), satellitePostDto.getNaturalSatelitte()));
		if(satellitePostDto.getPlanetId() == null) {
			return satelliteRepository.save(satellite);
		}
		Optional<Planet> optionalPlanet = planetRepository.findById(satellitePostDto.getPlanetId());
		if(!optionalPlanet.isPresent()) {
			return null;
		}
		satellite.setPlanet(optionalPlanet.get());
		return satelliteRepository.save(satellite);
	}

	@Override
	public Satellite deleteSatellite(Long satelliteId) {
		Optional<Satellite> optionalSatellite = satelliteRepository.findById(satelliteId);
		if(!optionalSatellite.isPresent()) {
			return null;
		}
		Satellite satellite = optionalSatellite.get();
		satelliteRepository.delete(satellite);
		return satellite;
	}

	@Override
	public List<SatelliteShowDto> onePlanetSatelitteData(Long planetId) {
		Optional<Planet> optionalPlanet = planetRepository.findById(planetId);
		if(!optionalPlanet.isPresent()) {
			return null;
		}
		Planet planet = optionalPlanet.get();
		List<Satellite> satellites = planet.getSatellites();
		List<SatelliteShowDto> satellitesShow = new ArrayList<>();
		for(Satellite s : satellites) {
			SatelliteShowDto ssd = new SatelliteShowDto(s);
			satellitesShow.add(ssd);
		}
		return satellitesShow;
	}
	
}
