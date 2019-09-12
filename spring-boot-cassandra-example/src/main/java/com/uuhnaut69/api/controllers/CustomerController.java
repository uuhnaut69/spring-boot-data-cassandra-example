package com.uuhnaut69.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.entities.Customer;
import com.uuhnaut69.api.services.CustomerService;

/**
 * @author uuhnaut
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer req) {
		Customer customer = customerService.create(req);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/active/{active}")
	public ResponseEntity<List<Customer>> getCustomerByStatus(@PathVariable boolean active) {
		List<Customer> list = customerService.getCustomerByStatus(active);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/detele/{id}")
	public ResponseEntity<String> deleteById(@PathVariable UUID id) {
		customerService.deleteById(id);
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@GetMapping("/age/{age}")
	public ResponseEntity<List<Customer>> getByAge(@PathVariable int age) {
		List<Customer> list = customerService.getByAge(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
