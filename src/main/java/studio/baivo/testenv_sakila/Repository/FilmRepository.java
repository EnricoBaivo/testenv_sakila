package studio.baivo.testenv_sakila.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import studio.baivo.testenv_sakila.model.Film;

import java.util.Set;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
public interface FilmRepository extends CrudRepository<Film, Long> {
//    jpql

public Set<Film> getFilmsByTitle(String searchTitle);
@Query("select f from Film f where f.title like CONCAT( :pTitle,  '%')")
public Set<Film> hahaha (@Param("pTitle") String searchTitle);

}