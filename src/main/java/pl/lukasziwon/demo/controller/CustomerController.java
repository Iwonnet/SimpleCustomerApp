package pl.lukasziwon.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.lukasziwon.demo.entity.Customer;
import pl.lukasziwon.demo.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerController{

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	

	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);

		customerService.saveCustomer(theCustomer);

		return theCustomer;

	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.findById(customerId);

		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}

		return theCustomer;
	}

	@PutMapping("/saveCustomer")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	@DeleteMapping("/deleteCustomers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.findById(customerId);
		if (tempCustomer == null) {
			throw new RuntimeException("Campaign id not found : " + customerId);
		}

		return "Deleted campaign id - " + customerId;
	}

}
