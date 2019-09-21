package pl.lukasziwon.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.lukasziwon.demo.dao.CustomerDAO;

import pl.lukasziwon.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);

	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);

	}

}
