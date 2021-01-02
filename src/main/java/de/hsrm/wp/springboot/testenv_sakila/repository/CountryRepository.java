package de.hsrm.wp.springboot.testenv_sakila.repository;

import de.hsrm.wp.springboot.testenv_sakila.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country getCountryByCountry(String country);
    Country getCountryByCountryId(Long countryID);

}
