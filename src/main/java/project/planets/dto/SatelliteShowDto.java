package project.planets.dto;

import project.planets.model.Satellite;

public class SatelliteShowDto {

	private Long id;
	
	private String name;
	
	private Long surfaceArea ;
	
	private Long mass;
	
	private Boolean naturalSatelitte;
	
	public SatelliteShowDto (Satellite satellite) {
		this.id = satellite.getId();
		this.name = satellite.getName();
		this.surfaceArea = satellite.getSurfaceArea();
		this.mass = satellite.getMass();
		this.naturalSatelitte = satellite.getNaturalSatelitte();
	}

	public SatelliteShowDto() {
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

	public Boolean getNaturalSatelitte() {
		return naturalSatelitte;
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

	public void setNaturalSatelitte(Boolean naturalSatelitte) {
		this.naturalSatelitte = naturalSatelitte;
	}
	
	
}
