package pl.lukasziwon.demo.dao;

import java.util.List;


import pl.lukasziwon.demo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();

	public void saveCustomer(Customer theCustomer);

	public Customer findById(int theId);

	public void deleteById(int theId);
}
