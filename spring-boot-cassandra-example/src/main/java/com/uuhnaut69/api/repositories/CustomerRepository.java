package com.uuhnaut69.api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.uuhnaut69.api.entities.Customer;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface CustomerRepository extends CassandraRepository<Customer, UUID> {
	@Query(value = "select * from customer where age=?0 allow filtering")
	List<Customer> findByAge(int age);

	@Query(value = "select * from customer where active=?0 allow filtering")
	List<Customer> findByCustomerActive(boolean active);
}
