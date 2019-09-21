package pl.lukasziwon.demo.service;

import java.util.List;

import pl.lukasziwon.demo.entity.Customer;



public interface CustomerService {
	
	public List<Customer> findAll();
	
	public void saveCustomer(Customer theCustomer);
	
	public Customer findById(int theId);
	
	public void deleteById(int theId);

}
