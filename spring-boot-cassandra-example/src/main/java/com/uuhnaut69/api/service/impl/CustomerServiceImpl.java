package com.uuhnaut69.api.service.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.uuhnaut69.api.model.Customer;
import com.uuhnaut69.api.repository.CustomerRepository;
import com.uuhnaut69.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project spring-boot-cassandra-example
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        customer.setId(UUIDs.timeBased());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomerByStatus(boolean isActive) {
        return customerRepository.findByCustomerActive(isActive);
    }

    @Override
    public List<Customer> getByAge(int age) {
        return customerRepository.findByAge(age);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }

}
