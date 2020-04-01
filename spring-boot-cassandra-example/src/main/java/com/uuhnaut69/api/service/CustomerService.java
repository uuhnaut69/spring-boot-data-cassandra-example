package com.uuhnaut69.api.service;

import com.uuhnaut69.api.model.Customer;

import java.util.List;
import java.util.UUID;

/**
 * @author uuhnaut
 */
public interface CustomerService {

	Customer create(Customer customer);

	List<Customer> getCustomerByStatus(boolean isActive);

	List<Customer> getByAge(int age);

	void deleteById(UUID id);
}
