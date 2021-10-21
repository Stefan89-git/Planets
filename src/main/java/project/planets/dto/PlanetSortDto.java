package project.planets.dto;

import project.planets.model.Planet;

public class PlanetSortDto {

	private Long id;
	
	private String name;
	
	private Long surfaceArea;
	
	private Long mass;
	
	private Long distanceFromSun;
	
	private Integer averageSurfaceTemperature;
	
	private Integer numberOfSatellites;
	
	public PlanetSortDto(Planet planet) {
		this.id = planet.getId();
		this.name = planet.getName();
		this.surfaceArea = planet.getSurfaceArea();
		this.mass = planet.getMass();
		this.distanceFromSun = planet.getDistanceFromSun();
		this.averageSurfaceTemperature = planet.getAverageSurfaceTemperature();
		this.numberOfSatellites = planet.getSatellites().size();
	}

	public PlanetSortDto() {
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

	public Integer getSatellites() {
		return numberOfSatellites;
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

	public void setSatellites(Integer satellites) {
		this.numberOfSatellites = satellites;
	}
	
	
}
