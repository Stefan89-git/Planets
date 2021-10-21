package project.planets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Satellite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "satellite_id")
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "surface_area_in_million_km²")
	private Long surfaceArea ;
	
	@Column(name = "mass_in_quintillion_kg")
	private Long mass;
	
	@Column
	private Boolean naturalSatelitte;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "planet_id")
	private Planet planet;

	public Satellite() {
		super();
	}

	public Satellite(String name, Long surfaceArea, Long mass, Boolean naturalSatelitte, Planet planet) {
		super();
		this.name = name;
		this.surfaceArea = surfaceArea;
		this.mass = mass;
		this.naturalSatelitte = naturalSatelitte;
		this.planet = planet;
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

	public Planet getPlanet() {
		return planet;
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

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	
}
