package project.planets.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.planets.dto.PlanetPostDto;
import project.planets.dto.PlanetShowDto;
import project.planets.model.Planet;
import project.planets.repositories.PlanetRepository;
import project.planets.services.PlanetService;

@RestController
@RequestMapping(path = "/api/planets")
public class PlanetController {

	@Autowired
	private PlanetService planetService;
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@GetMapping(path = "/sorted")
	public ResponseEntity<?> findAllSorted(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
									 @RequestParam(required = false, defaultValue = "10") Integer pageSize,
									 @RequestParam(required = false, defaultValue = "satellites") String sortBy){
		List<Planet> list= planetService.findAllSorted(pageNo, pageSize, sortBy);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/filtered")
	public ResponseEntity<?> findAllFiltered(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
									 @RequestParam(required = false, defaultValue = "10") Integer pageSize,
									 @RequestParam(required = false, defaultValue = "") String name){
		Page<Planet> list= planetService.findAllFiltered(name, pageNo, pageSize);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id){
		Optional<Planet> optionalPlanet = planetRepository.findById(id);
		if(!optionalPlanet.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		PlanetShowDto planet = planetService.findOne(id);
		return new ResponseEntity<>(planet, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createPlanet(@RequestBody PlanetPostDto planetPostDto){
		return new ResponseEntity<>(planetService.createPlanet(planetPostDto), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> changePlanet(@PathVariable Long id, @RequestBody PlanetPostDto planetPostDto){
		Optional<Planet> optionalPlanet = planetRepository.findById(id);
		if(!optionalPlanet.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(planetService.updatePlanet(id, planetPostDto), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deletePlanet(@PathVariable Long id){
		Optional<Planet> optionalPlanet = planetRepository.findById(id);
		if(!optionalPlanet.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(planetService.deletePlanet(id), HttpStatus.OK);
	}
}
