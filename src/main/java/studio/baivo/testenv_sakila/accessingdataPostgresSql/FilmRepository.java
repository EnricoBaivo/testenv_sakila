package studio.baivo.testenv_sakila.accessingdataPostgresSql;

import org.springframework.data.repository.CrudRepository;
import studio.baivo.testenv_sakila.accessingdataPostgresSql.Film;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Film, Integer> {

}