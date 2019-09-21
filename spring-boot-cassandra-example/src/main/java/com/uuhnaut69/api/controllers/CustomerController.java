package com.uuhnaut69.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.entities.Customer;
import com.uuhnaut69.api.services.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author uuhnaut
 *
 */
@Api(value = "Customer RestController")
@RestController
@RequestMapping(value = "/v1/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@ApiOperation(value = "create new customer", notes = "Create new customer")
	@PutMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer req) {
		Customer customer = customerService.create(req);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@ApiOperation(value = "Get list user", notes = "Get list user based on active status")
	@ApiImplicitParam(name = "active", value = "isactive", required = true, dataType = "boolean", paramType = "path")
	@GetMapping("/active/{isactive}")
	public ResponseEntity<List<Customer>> getCustomerByStatus(@PathVariable boolean isactive) {
		List<Customer> list = customerService.getCustomerByStatus(isactive);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete user", notes = "Delete user based on user uuid")
	@ApiImplicitParam(name = "id", value = "user's id", required = true, dataType = "uuid", paramType = "path")
	@DeleteMapping("/detele/{id}")
	public ResponseEntity<String> deleteById(@PathVariable UUID id) {
		customerService.deleteById(id);
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@ApiOperation(value = "Get user", notes = "Get user based on user's age")
	@ApiImplicitParam(name = "age", value = "user's age", required = true, dataType = "int", paramType = "path")
	@GetMapping("/age/{age}")
	public ResponseEntity<List<Customer>> getByAge(@PathVariable int age) {
		List<Customer> list = customerService.getByAge(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
