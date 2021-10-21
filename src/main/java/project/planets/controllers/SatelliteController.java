package project.planets.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.planets.dto.SatellitePostDto;
import project.planets.dto.SatelliteShowDto;
import project.planets.model.Planet;
import project.planets.model.Satellite;
import project.planets.repositories.PlanetRepository;
import project.planets.repositories.SatelliteRepository;
import project.planets.services.SatelliteService;

@RestController
@RequestMapping(path = "/api/satellites")
public class SatelliteController {
	
	@Autowired
	private SatelliteService satelliteService;

	@Autowired
	private SatelliteRepository satelliteRepository;
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> oneSatelliteData(@PathVariable Long id){
		Optional<Satellite> optionalSatellite = satelliteRepository.findById(id);
		if(!optionalSatellite.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(optionalSatellite.get(), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/satellitesOfPlanet/{id}")
	public ResponseEntity<?> findSatellitesOfOnePlanet(@PathVariable Long id){
		Optional<Planet> optionalPlanet = planetRepository.findById(id);
		if(!optionalPlanet.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<SatelliteShowDto> satellites = satelliteService.onePlanetSatelitteData(id);
		return new ResponseEntity<>(satellites, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createSatellite(@RequestBody SatellitePostDto satellitePostDto){
		Optional<Planet> optionalPlanet = planetRepository.findById(satellitePostDto.getPlanetId());
		if(!optionalPlanet.isPresent() || !optionalPlanet.get().getActive()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(satelliteService.createSatellite(satellitePostDto), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> updateSatellite(@PathVariable Long id, @RequestBody SatellitePostDto satellitePostDto){
		Optional<Satellite> optionalSatellite = satelliteRepository.findById(id);
		if(!optionalSatellite.isPresent() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(satelliteService.updateSatellite(id, satellitePostDto), HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteSatellite(@PathVariable Long id){
		Optional<Satellite> optionalSatellite = satelliteRepository.findById(id);
		if(!optionalSatellite.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(satelliteService.deleteSatellite(id), HttpStatus.ACCEPTED);
	}
}
