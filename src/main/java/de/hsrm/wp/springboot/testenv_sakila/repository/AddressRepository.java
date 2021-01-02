package de.hsrm.wp.springboot.testenv_sakila.repository;

import de.hsrm.wp.springboot.testenv_sakila.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Address getAddressByAddressId(long addressId);

}
