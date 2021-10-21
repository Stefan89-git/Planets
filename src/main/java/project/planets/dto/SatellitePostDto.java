package project.planets.dto;

import project.planets.model.Satellite;

public class SatellitePostDto {

	private Long id;
	
	private String name;
	
	private Long surfaceArea ;
	
	private Long mass;
	
	private Boolean naturalSatelitte;
	
	private Long planetId;
	
	public Satellite toEntity(SatellitePostDto satellitePostDto) {
		Satellite satellite = new Satellite();
		satellite.setName(satellitePostDto.getName());
		satellite.setSurfaceArea(satellitePostDto.getSurfaceArea());
		satellite.setMass(satellitePostDto.getMass());
		satellite.setNaturalSatelitte(satellitePostDto.getNaturalSatelitte());
		return satellite;
	}

	public SatellitePostDto() {
		super();
	}

	public SatellitePostDto(String name, Long surfaceArea, Long mass, Boolean naturalSatelitte, Long planetId) {
		super();
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.naturalSatelitte = naturalSatelitte;
		this.planetId = planetId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Long surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Long getMass() {
		return mass;
	}

	public void setMass(Long mass) {
		this.mass = mass;
	}

	public Boolean getNaturalSatelitte() {
		return naturalSatelitte;
	}

	public void setNaturalSatelitte(Boolean naturalSatelitte) {
		this.naturalSatelitte = naturalSatelitte;
	}

	public Long getPlanetId() {
		return planetId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPlanetId(Long planetId) {
		this.planetId = planetId;
	}

	
}
