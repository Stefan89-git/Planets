package project.planets.dto;

import java.util.List;

import project.planets.model.Planet;

public class PlanetShowDto {

	private Long id;
	
	private String name;
	
	private Long surfaceArea;
	
	private Long mass;
	
	private Long distanceFromSun;
	
	private Integer averageSurfaceTemperature;
	
	private List<SatelliteShowDto> satellites;
	
	public PlanetShowDto(Planet planet) {
		this.id = planet.getId();
		this.name = planet.getName();
		this.surfaceArea = planet.getSurfaceArea();
		this.mass = planet.getMass();
		this.distanceFromSun = planet.getDistanceFromSun();
		this.averageSurfaceTemperature = planet.getAverageSurfaceTemperature();
	}

	public PlanetShowDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getSurfaceArea() {
		return surfaceArea;
	}

	public Long getMass() {
		return mass;
	}

	public Long getDistanceFromSun() {
		return distanceFromSun;
	}

	public Integer getAverageSurfaceTemperature() {
		return averageSurfaceTemperature;
	}

	public List<SatelliteShowDto> getSatellites() {
		return satellites;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurfaceArea(Long surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public void setMass(Long mass) {
		this.mass = mass;
	}

	public void setDistanceFromSun(Long distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	public void setAverageSurfaceTemperature(Integer averageSurfaceTemperature) {
		this.averageSurfaceTemperature = averageSurfaceTemperature;
	}

	public void setSatellites(List<SatelliteShowDto> satellites) {
		this.satellites = satellites;
	}
	
	
}
