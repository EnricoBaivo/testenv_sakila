package de.hsrm.wp.springboot.testenv_sakila.repository;

import de.hsrm.wp.springboot.testenv_sakila.model.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ActorRepository extends CrudRepository<Actor, Long> {

}
