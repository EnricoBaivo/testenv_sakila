package de.hsrm.wp.springboot.testenv_sakila.repository;


import de.hsrm.wp.springboot.testenv_sakila.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

    City getCityByCity(String city);
    City getCityByCityId(long cityID);

}
