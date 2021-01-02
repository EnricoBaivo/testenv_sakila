package de.hsrm.wp.springboot.testenv_sakila.repository;

import de.hsrm.wp.springboot.testenv_sakila.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
