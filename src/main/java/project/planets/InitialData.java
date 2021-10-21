package project.planets;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.planets.model.Planet;
import project.planets.model.Satellite;
import project.planets.repositories.PlanetRepository;
import project.planets.repositories.SatelliteRepository;

@Component
public class InitialData {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private SatelliteRepository satelliteRepository;
	
	@PostConstruct
	public void init() {
		Planet planet1 = new Planet("Earth", 510l, 6l, 149l, 15, true);
		planetRepository.save(planet1);
		
		Planet planet2 = new Planet("Mars", 145l, 1l, 244l, -60, true);
		planetRepository.save(planet2);
		
		Planet planet3 = new Planet("Jupiter", 61000l, 1001l, 750l, -145, true);
		planetRepository.save(planet3);
		
		Satellite satellite1 = new Satellite("Moon", 38l, 73l, true, planet1);
		satelliteRepository.save(satellite1);
		
		Satellite satellite2 = new Satellite("Phobos", 1l, 1l, true, planet2);
		satelliteRepository.save(satellite2);
		
		Satellite satellite3 = new Satellite("Deimos", 1l, 1l, true, planet2);
		satelliteRepository.save(satellite3);
		
		Satellite satellite4 = new Satellite("Europa", 31l, 48l, true, planet3);
		satelliteRepository.save(satellite4);
		
		Satellite satellite5 = new Satellite("Ganymede", 87l, 413l, true, planet3);
		satelliteRepository.save(satellite5);
		
		Satellite satellite6 = new Satellite("Callisto", 73l, 107l, true, planet3);
		satelliteRepository.save(satellite6);
	}
}