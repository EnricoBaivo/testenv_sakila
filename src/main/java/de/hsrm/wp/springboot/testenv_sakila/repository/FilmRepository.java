package de.hsrm.wp.springboot.testenv_sakila.repository;

import de.hsrm.wp.springboot.testenv_sakila.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
public interface FilmRepository extends CrudRepository<Film, Long> {
//    jpa

// Set<Actor> findByFirstNameLikeAndLastNameLikeAllIgnoreCase (String firstName, String lastName);


//    jpql
Set<Film> getFilmsByTitle(String searchTitle);
@Query("select f from Film f where f.title like CONCAT( :pTitle,  '%')")
Set<Film> hahaha(@Param("pTitle") String searchTitle);

}