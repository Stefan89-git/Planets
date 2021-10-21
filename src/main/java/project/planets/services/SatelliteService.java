package project.planets.services;

import java.util.List;

import project.planets.dto.SatellitePostDto;
import project.planets.dto.SatelliteShowDto;
import project.planets.model.Satellite;

public interface SatelliteService {
	
	public List<SatelliteShowDto> onePlanetSatelitteData(Long planetId);

	public Satellite createSatellite(SatellitePostDto satelliteDto);
	
	public Satellite deleteSatellite(Long satelliteId);
	
	public Satellite updateSatellite(Long satelliteId, SatellitePostDto satellitePostDto);
}
