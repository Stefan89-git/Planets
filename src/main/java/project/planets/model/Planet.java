package project.planets.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planet_id")
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "surface_area_in_million_km²")
	private Long surfaceArea;
	
	@Column(name = "mass_in_sextillion_kg")
	private Long mass;
	
	@Column(name = "distance_from_sun_in_million_km")
	private Long distanceFromSun;
	
	@JsonIgnore
	@Column
	private Boolean active;
	
	@Column(name = "average_surface_temperature_in_°C")
	private Integer averageSurfaceTemperature;
	
	@OneToMany(mappedBy = "planet", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Satellite> satellites = new ArrayList<Satellite>();

	public Planet() {
		super();
	}

	public Planet(String name, Long surfaceArea, Long mass, Long distanceFromSun, Integer averageSurfaceTemperature,
			Boolean active){
		super();
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.distanceFromSun = distanceFromSun;
		this.averageSurfaceTemperature = averageSurfaceTemperature;
		this.active = active;
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

	public Long getDistanceFromSun() {
		return distanceFromSun;
	}

	public void setDistanceFromSun(Long distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	public Integer getAverageSurfaceTemperature() {
		return averageSurfaceTemperature;
	}

	public void setAverageSurfaceTemperature(Integer averageSurfaceTemperature) {
		this.averageSurfaceTemperature = averageSurfaceTemperature;
	}

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
