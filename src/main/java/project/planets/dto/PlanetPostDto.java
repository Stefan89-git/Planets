package project.planets.dto;

import project.planets.model.Planet;

public class PlanetPostDto {

	private Long id;
	
	private String name;
	
	private Long surfaceArea;
	
	private Long mass;
	
	private Long distanceFromSun;
	
	private Integer averageSurfaceTemperature;
	
	private Boolean active;
	
	public Planet toEntity(PlanetPostDto planetPostDto) {
		Planet planet = new Planet();
		planet.setName(planetPostDto.getName());
		planet.setSurfaceArea(planetPostDto.getSurfaceArea());
		planet.setMass(planetPostDto.getMass());
		planet.setDistanceFromSun(planetPostDto.getDistanceFromSun());
		planet.setAverageSurfaceTemperature(planetPostDto.getAverageSurfaceTemperature());
		return planet;
	}

	public PlanetPostDto() {
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


}
