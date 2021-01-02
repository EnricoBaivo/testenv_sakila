package de.hsrm.wp.springboot.testenv_sakila.repository;


import de.hsrm.wp.springboot.testenv_sakila.model.Store;
import org.springframework.data.repository.CrudRepository;


public interface StoreRepository extends CrudRepository<Store, Long> {

    Store getStoreByStoreId(long searchId);

}
