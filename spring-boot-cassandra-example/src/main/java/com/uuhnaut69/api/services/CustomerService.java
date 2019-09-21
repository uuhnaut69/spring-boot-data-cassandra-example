package com.uuhnaut69.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.uuhnaut69.api.entities.Customer;
import com.uuhnaut69.api.repositories.CustomerRepository;

/**
 * @author uuhnaut
 *
 */
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer create(Customer req) {
		req.setId(UUIDs.timeBased());
		return customerRepository.save(req);
	}

	public List<Customer> getCustomerByStatus(boolean isactive) {
		return customerRepository.findByCustomerActive(isactive);
	}

	public List<Customer> getByAge(int age) {
		return customerRepository.findByAge(age);
	}

	public void deleteById(UUID id) {
		customerRepository.deleteById(id);
	}
}
