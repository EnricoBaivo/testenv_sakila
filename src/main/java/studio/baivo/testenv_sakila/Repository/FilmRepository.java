package studio.baivo.testenv_sakila.Repository;

import org.springframework.data.repository.CrudRepository;
import studio.baivo.testenv_sakila.entitys.Film;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Film, Integer> {

}