package de.hsrm.wp.springboot.testenv_sakila.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the country database table.
 * 
 */
@Entity
public class Country extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COUNTRY_COUNTRYID_GENERATOR", sequenceName = "COUNTRY_COUNTRY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_COUNTRYID_GENERATOR")
	@Column(name = "country_id")
	private Long countryId;

	private String country;

	// bi-directional many-to-one association to City
	@OneToMany(mappedBy = "country")
	private Set<City> cities;

	public Country() {
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCountry(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCountry(null);

		return city;
	}

}