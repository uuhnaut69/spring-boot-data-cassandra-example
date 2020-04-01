package com.uuhnaut69.api.repository;

import com.uuhnaut69.api.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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
