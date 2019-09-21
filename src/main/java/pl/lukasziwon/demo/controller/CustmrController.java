package pl.lukasziwon.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.lukasziwon.demo.entity.Customer;
import pl.lukasziwon.demo.service.CustomerService;

@Controller
@RequestMapping("/mycustomers")
public class CustmrController {

	private CustomerService customerService;

	@Autowired
	public CustmrController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("customers", theCustomers);
		return "customers/list";
	}
	
	@PostMapping("/saveTheCustomer")
	public String saveTheCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/mycustomers/list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "/customers/customers-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customers/customers-form";
	}
	
	@GetMapping("/deleteTheCustomer")
	public String deleteTheCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteById(theId);
		return "redirect:/mycustomers/list";
	}
}
